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

import com.springmvc.dao.imp.ICommentDao;
import com.springmvc.model.Comment;

/**
 * @author rinnv
 *
 */
@Repository
@Transactional
public class CommentDao implements ICommentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * Lọc bình luận theo id của bài viết
	 * 
	 */
	@Override
	public List<Comment> getAll(int id_news) {
		return jdbcTemplate.query("select * from comment where id_news = " + id_news + "  order by id Desc",
				new RowMapper<Comment>() {
					public Comment mapRow(ResultSet resultSet, int row) throws SQLException {
						Comment comment = new Comment(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3),
								resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
						return comment;
					}
				});
	}

	/*
	 *  Bình luận bài viết
	 */
	@Override
	public int create(Comment comment) {
		// TODO Auto-generated method stub
		String sql = "insert into comment ( id_news ,email,username, comment,date_cmt) values (?,?,?,?)";
		return jdbcTemplate.update(sql, comment.getId_news() ,comment.getEmail(),comment.getUsername(), comment.getComment(),
				LocalDateTime.now().toString());
	}
	/*
	 *  Đếm bình luận của bài viết
	 */
	@Override
	public int countComment(int id) {
		// TODO Auto-generated method stub
		String sql ="select count(*) from comment where id_news ="+id+"";
		return jdbcTemplate.queryForObject(sql,Integer.class);
	}

}
