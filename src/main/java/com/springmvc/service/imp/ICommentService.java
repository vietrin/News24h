package com.springmvc.service.imp;

import java.util.List;

import com.springmvc.model.Comment;
/**
 * @author rinnv
 *
 */
public interface ICommentService {
	public List<Comment> getAll(int id);
	public int create(Comment comment);
	public int countComment(int id) ;
}
