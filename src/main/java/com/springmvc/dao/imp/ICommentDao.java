package com.springmvc.dao.imp;

import java.util.List;

import com.springmvc.model.Comment;

public interface ICommentDao {
	public List<Comment> getAll(int id);
	public int create(Comment comment);
}
