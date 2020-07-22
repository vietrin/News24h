package com.springmvc.model;

public class Comment {
	private int id, id_news, id_account;
	private String commnet, date_create;

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

	public int getId_account() {
		return id_account;
	}

	public void setId_account(int id_account) {
		this.id_account = id_account;
	}

	public String getCommnet() {
		return commnet;
	}

	public void setCommnet(String commnet) {
		this.commnet = commnet;
	}

	public String getDate_create() {
		return date_create;
	}

	public void setDate_create(String date_create) {
		this.date_create = date_create;
	}

	public Comment(int id, int id_news, int id_account, String commnet, String date_create) {
		super();
		this.id = id;
		this.id_news = id_news;
		this.id_account = id_account;
		this.commnet = commnet;
		this.date_create = date_create;
	}

}
