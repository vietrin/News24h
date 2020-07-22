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

import com.springmvc.dao.imp.INewsDao;
import com.springmvc.model.News;

/**
 * @author rinnv
 *
 */
@Repository
@Transactional
public class NewsDao implements INewsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * Lấy toàn bộ tin tức có trong db
	 */
	@Override
	public List<News> getAll() {
		return jdbcTemplate.query("select * from news order by id Desc", new RowMapper<News>() {
			public News mapRow(ResultSet resultSet, int row) throws SQLException {
				News news = new News(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
						resultSet.getString(8), resultSet.getInt(9), resultSet.getString(10), resultSet.getString(11),
						resultSet.getString(12));
				return news;
			}
		});
	}

	/*
	 * Thêm mới tin tức
	 */
	@Override
	public int insert(News news) {
		String sql = "insert into news (id_category,title,desrc,url_thumb,keyword,body,[image],read_count,date_update,date_create,person_create) values (?,?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, news.getId_category(), news.getTitlte(), news.getDescr(), news.getUrl_thumb(),
				news.getKeyword(), news.getBody(), news.getImage(), news.getRead_count(), news.getDate_update(),
				LocalDateTime.now().toString(), news.getPerson_create());
	}

	/*
	 * Cập nhập tin tức
	 */
	@Override
	public int update(News news) {
		String sql = "update news set id_category=?,title=?,desrc=?,url_thumb=?,keyword=?,body=?,image=?,read_count=?,date_update=?,person_create=? where id =? ";
		return jdbcTemplate.update(sql, news.getId_category(), news.getTitlte(), news.getDescr(), news.getUrl_thumb(),
				news.getKeyword(), news.getBody(), news.getImage(), news.getRead_count(),
				LocalDateTime.now().toString(), news.getPerson_create(), news.getId());
	}

	/*
	 * Xóa tin tức
	 */
	@Override
	public int delete(int id) {
		String sql = "delete from news where id = ? ";
		return jdbcTemplate.update(sql, id);
	}

	/*
	 * Trả về tin tức thông qua id
	 */
	@Override
	public News findById(int id) {
		return jdbcTemplate.queryForObject("select * from news where id= ? ", new Object[] { id },
				new RowMapper<News>() {
					public News mapRow(ResultSet resultSet, int row) throws SQLException {
						News news = new News(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
								resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
								resultSet.getString(7), resultSet.getString(8), resultSet.getInt(9),
								resultSet.getString(10), resultSet.getString(11), resultSet.getString(12));
						return news;
					}
				});

	}

	/*
	 * Cập nhập số lượt đọc của tin tức
	 */
	@Override
	public int update_ReadCount(int id) {
		String sql = "update news set read_count= (read_count + 1 ) where id = ? ";
		return jdbcTemplate.update(sql, id);
	}

	/*
	 * kiểm tra tồn tại của id
	 */
	@Override
	public int check(int id) {
		String sql = "select * from news where id = ? ";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, Integer.class);
	}

	/*
	 * Hiển thị 4 bài viết có lượt đọc nhiều nhất
	 */
	@Override
	public List<News> getAllByReadCount() {
		return jdbcTemplate.query("select top(4) * from news order by read_count Desc", new RowMapper<News>() {
			public News mapRow(ResultSet resultSet, int row) throws SQLException {
				News news = new News(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
						resultSet.getString(8), resultSet.getInt(9), resultSet.getString(10), resultSet.getString(11),
						resultSet.getString(12));
				return news;
			}
		});
	}

//	public String getDateTime() {
//	 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
//	    Date date = new Date();
//	return formatter.format(date);
//}

}
