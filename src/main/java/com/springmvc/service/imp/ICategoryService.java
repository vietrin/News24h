package com.springmvc.service.imp;

import java.util.List;

import com.springmvc.model.Category;

/**
 * @author rinnv
 *
 */
public interface ICategoryService {
	public List<Category> getAll();
	public int insert(Category category);
	public int update(Category category);
	public int delete(int id);
	public Category findById(int id);
}
