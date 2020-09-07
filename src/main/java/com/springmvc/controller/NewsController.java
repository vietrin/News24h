package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.model.News;
import com.springmvc.service.NewsService;
 
@Controller
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping(value = {"views"})
	public String view (Model model) {
		List<News> list = new ArrayList<News>();
		try {
			list = newsService.getAll();
			model.addAttribute( "list",list);
		} catch (Exception e) {
		}
		return "views";
	}
}
