package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.CommentDao;
import com.springmvc.model.Comment;
import com.springmvc.service.imp.ICommentService;

/**
 * @author rinnv
 *
 */
@Transactional
@Service
public class CommentService implements ICommentService {
	@Autowired
	private CommentDao commentDao;

	@Override
	public List<Comment> getAll(int id) {
		// TODO Auto-generated method stub
		return commentDao.getAll(id);
	}

	@Override
	public int create(Comment comment) {
		// TODO Auto-generated method stub
		return commentDao.create(comment);
	}

	@Override
	public int countComment(int id) {
		// TODO Auto-generated method stub
		int count = commentDao.countComment(id);
		return count > 0 ? count : 0;
	}

}
