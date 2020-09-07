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

import com.springmvc.model.Category;
import com.springmvc.service.CategoryService;

/**
 * @author rinnv
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api")
public class CategoryRest {
	@Autowired
	private CategoryService categoryService;

	/*
	 * api lấy tất cả danh mục
	 */
	@RequestMapping(value = "category", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> getAll() {
		List<Category> list = new ArrayList<Category>();
		try {
			list = categoryService.getAll();
			return ResponseEntity.ok().body(list);
		} catch (Exception ex) {

		}
		return ResponseEntity.ok().body(null);
	}

	/*
	 * api thêm mới danh mục
	 */
	@RequestMapping(value = "category", method = RequestMethod.POST)
	public ResponseEntity<Integer> insert(@RequestBody Category category) {
		return ResponseEntity.ok().body(categoryService.insert(category));
	}

	/*
	 * api xóa danh mục
	 */
	@RequestMapping(value = "category/{id}", method = RequestMethod.POST)
	public ResponseEntity<Integer> delete(@PathVariable int id) {
		return ResponseEntity.ok().body(categoryService.delete(id));
	}

	/*
	 * api cập nhập danh mục
	 */
	@RequestMapping(value = "category/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Integer> update(@PathVariable int id, @RequestBody Category category) {
		Category categoryN = categoryService.findById(id);
		if (categoryN != null) {
			categoryN = new Category(id, category.getName(), category.getDate_create(), category.getDate_update(),
					category.getPerson_create());
			return ResponseEntity.ok().body(categoryService.update(category));
		}
		return ResponseEntity.ok().body(0);
	}
}
