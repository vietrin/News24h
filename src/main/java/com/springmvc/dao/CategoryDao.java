package com.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.imp.ICategoryDao;
import com.springmvc.model.Category;

/**
 * @author rinnv
 *
 */
@Repository
@Transactional
public class CategoryDao implements ICategoryDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * lấy danh sách toàn bộ các danh mục trong db
	 */
	@Override
	public List<Category> getAll() {

		return jdbcTemplate.query("select * from category", new RowMapper<Category>() {
			public Category mapRow(ResultSet resultSet, int row) throws SQLException {
				Category Category = new Category(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5));
				return Category;
			}
		});
	}

	/*
	 * Thêm mới danh mục vào db
	 */
	@Override
	public int insert(Category category) {
		String sql = "insert into category (name,date_update,date_create,person_create) values (?,?,?,?)";
		return jdbcTemplate.update(sql, category.getName(), category.getDate_update(), LocalDateTime.now().toString(),
				category.getPerson_create());
	}

	/*
	 * Cập nhập lại danh mục vào lại db
	 */
	@Override
	public int update(Category category) {
		String sql = "update category set name=?,date_update=?,date_create=?,person_create=? where id = ?";
		return jdbcTemplate.update(sql, category.getName(), LocalDateTime.now().toString(), category.getDate_create(),
				category.getPerson_create(), category.getId());
	}

	/*
	 * Xóa danh mục được chọn khỏi db
	 */
	@Override
	public int delete(int id) {
		String sql = "delete from category  where id = ?";
		return jdbcTemplate.update(sql, id);
	}

	/*
	 * Tìm kiếm thể loại theo id
	 */
	
	@Override
	public Category findById(int id) {
		String sql = "select * from category  where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapper<Category>() {
			public Category mapRow(ResultSet resultSet, int row) throws SQLException {
				Category Category = new Category(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5));
				return Category;
			}
		});
	}

}
