package com.springmvc.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.model.News;
import com.springmvc.service.NewsService;

/**
 * @author rinnv
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class NewsRest {
	
	@Autowired
	private NewsService newsService ;

	/*
	 * api lấy danh sách tin tức tất cả từ db
	 */
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public ResponseEntity<List<News>> getAll() {
		List<News> list = new ArrayList<News>();
		try {
			list = newsService.getAll();
			return ResponseEntity.ok().body(list);
		} catch (Exception e) {
		}
		return ResponseEntity.ok().body(null);
	}

	/*
	 * api lấy danh sách tin tức trong top đầu theo lượt xem từ db
	 */
	@RequestMapping(value = "/news/topview", method = RequestMethod.GET)
	public ResponseEntity<List<News>> getAllByReadCount() {
		List<News> list = new ArrayList<News>();
		try {
			list = newsService.getAllByReadCount();
			return ResponseEntity.ok().body(list);
		} catch (Exception e) {
		}
		return ResponseEntity.ok().body(null);
	}

	/*
	 * api thêm mới tin tức vào db
	 */
	@RequestMapping(value = "/news", method = RequestMethod.POST)
	public ResponseEntity<Integer> insert(@RequestBody News news) {
		return ResponseEntity.ok().body(newsService.insert(news));
	}

	/*
	 * api xóa tin tức khỏi db
	 */
	@RequestMapping(value = "/news/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> delete(@PathVariable int id) {
		return ResponseEntity.ok().body(newsService.delete(id));
	}

	/*
	 * api cập nhập tin tức trong db
	 */
	@RequestMapping(value = "/news/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Integer> update(@PathVariable int id ,@RequestBody News news) {
		News newss = newsService.checkById(id);
		if (newss != null) {
			newss = new News(id,news.getId_category(), news.getTitlte(), news.getDescr(), news.getUrl_thumb(),
					news.getKeyword(), news.getBody(), news.getImage(), news.getRead_count(), news.getDate_update(),
					news.getDate_create(), news.getPerson_create());
			return ResponseEntity.ok().body(newsService.update(newss));
		}
		return ResponseEntity.ok().body(0);
	}

	/*
	 * 	api lọc tin tức theo id , cập nhập lại sô lần đọc của tin tức
	 */
	@RequestMapping(value = "/news/{id}", method = RequestMethod.GET)
	public ResponseEntity<News> findById(@PathVariable int id) {
		News news = newsService.findById(id);
		if (news != null) {
			return ResponseEntity.ok().body(news);
		}
		return ResponseEntity.ok().body(null);
	}
}
