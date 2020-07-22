package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.CategoryDao;
import com.springmvc.model.Category;
import com.springmvc.service.imp.ICategoryService;

/**
 * @author rinnv
 *
 */
@Service
@Transactional
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return categoryDao.getAll();
	}

	@Override
	public int insert(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.insert(category);
	}

	@Override
	public int update(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.update(category);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return categoryDao.delete(id);
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return categoryDao.findById(id);
	}
	
}
