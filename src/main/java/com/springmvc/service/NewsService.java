package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.NewsDao;
import com.springmvc.model.News;
import com.springmvc.service.imp.INewsService;

/**
 * @author rinnv
 *
 */
@Service
@Transactional
public class NewsService implements INewsService {
	@Autowired
	private NewsDao newsDao;

	@Override
	public List<News> getAll() {
		return newsDao.getAll();
	}

	@Override
	public int insert(News news) {
		// TODO Auto-generated method stub
		return newsDao.insert(news);
	}

	@Override
	public int update(News news) {
		// TODO Auto-generated method stub
		return newsDao.update(news);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return newsDao.delete(id);
	}

	@Override
	public News findById(int id) {
		newsDao.update_ReadCount(id);
		return newsDao.findById(id);
	}

	@Override
	public int update_ReadCount(int id) {
		// TODO Auto-generated method stub
		return newsDao.update_ReadCount(id);
	}

	@Override
	public News checkById(int id) {
		return newsDao.findById(id);
	}

	@Override
	public List<News> getAllByReadCount() {
		// TODO Auto-generated method stub
		return newsDao.getAllByReadCount();
	}

}
