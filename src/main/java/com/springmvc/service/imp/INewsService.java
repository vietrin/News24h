package com.springmvc.service.imp;

import java.util.List;

import com.springmvc.model.News;

public interface INewsService {
	public List<News> getAll();
	public int insert(News news);
	public int update(News news);
	public int delete(int id);
	public News findById(int id);
	public int update_ReadCount(int id);
	public News checkById(int id);
	public List<News> getAllByReadCount();
}
