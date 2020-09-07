package com.springmvc.model;

public class Comment {
	private int id, id_news;
	private String username, email ,comment, date_create;

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_news() {
		return id_news;
	}

	public void setId_news(int id_news) {
		this.id_news = id_news;
	}

	public String getDate_create() {
		return date_create;
	}

	public void setDate_create(String date_create) {
		this.date_create = date_create;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Comment(int id, int id_news, String email,String username,  String comment, String date_create) {
		super();
		this.id = id;
		this.id_news = id_news;
		this.username = username;
		this.email = email;
		this.comment = comment;
		this.date_create = date_create;
	}

	
}
