package com.springmvc.dao.imp;

import java.util.List;

import com.springmvc.model.Category;

public interface ICategoryDao {
	public List<Category> getAll();
	public int insert(Category news);
	public int update(Category news);
	public int delete(int id);
	public Category findById(int id);
}
