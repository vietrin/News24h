package com.springmvc.model;

public class News {
	private int id, id_category, read_count;
	private String titlte, descr, url_thumb, keyword, body, image, date_update, date_create, person_create;

	public News() {
		// TODO Auto-generated constructor stub
	}

	public News(int id, int id_category, String titlte, String descr, String url_thumb, String keyword, String body,
			String image, int read_count, String date_update, String date_create, String person_create) {
		super();
		this.id = id;
		this.id_category = id_category;
		this.titlte = titlte;
		this.descr = descr;
		this.url_thumb = url_thumb;
		this.keyword = keyword;
		this.body = body;
		this.image = image;
		this.read_count = read_count;
		this.date_update = date_update;
		this.date_create = date_create;
		this.person_create = person_create;
	}

	public News(int id_category, String titlte, String descr, String url_thumb, String keyword, String body,
			String image, int read_count, String date_update, String date_create, String person_create) {
		super();
		this.id_category = id_category;
		this.titlte = titlte;
		this.descr = descr;
		this.url_thumb = url_thumb;
		this.keyword = keyword;
		this.body = body;
		this.image = image;
		this.read_count = read_count;
		this.date_update = date_update;
		this.date_create = date_create;
		this.person_create = person_create;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_category() {
		return id_category;
	}

	public void setId_category(int id_category) {
		this.id_category = id_category;
	}

	public String getTitlte() {
		return titlte;
	}

	public void setTitlte(String titlte) {
		this.titlte = titlte;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getUrl_thumb() {
		return url_thumb;
	}

	public void setUrl_thumb(String url_thumb) {
		this.url_thumb = url_thumb;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getRead_count() {
		return read_count;
	}

	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}

	public String getDate_update() {
		return date_update;
	}

	public void setDate_update(String date_update) {
		this.date_update = date_update;
	}

	public String getDate_create() {
		return date_create;
	}

	public void setDate_create(String date_create) {
		this.date_create = date_create;
	}

	public String getPerson_create() {
		return person_create;
	}

	public void setPerson_create(String person_create) {
		this.person_create = person_create;
	}

}
