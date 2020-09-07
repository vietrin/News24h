package com.springmvc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.model.Comment;
import com.springmvc.service.CommentService;

/**
 * @author rinnv
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CommentRest {
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "comment/{id}" ,method = RequestMethod.GET )
	public ResponseEntity<List<Comment>>getAll(@PathVariable int id){
		List <Comment> comments = commentService.getAll(id);
		return ResponseEntity.ok().body(comments);
	}
	@RequestMapping(value = "comment",method=RequestMethod.POST)
	public ResponseEntity<Object> create (@RequestBody Comment comment){
		return ResponseEntity.ok().body(commentService.create(comment));
	}
	@RequestMapping(value = "comment/count/{id}" ,method = RequestMethod.GET )
	public ResponseEntity<Object>getCountComment(@PathVariable int id){
		int count = commentService.countComment(id);
		return ResponseEntity.ok().body(count);
	}
}
