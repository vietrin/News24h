package com.springmvc.model;

public class Category {
	private int id;
	private String name, date_create, date_update, person_create;

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String name, String date_create, String date_update, String person_create) {
		super();
		this.id = id;
		this.name = name;
		this.date_create = date_create;
		this.date_update = date_update;
		this.person_create = person_create;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate_create() {
		return date_create;
	}

	public void setDate_create(String date_create) {
		this.date_create = date_create;
	}

	public String getDate_update() {
		return date_update;
	}

	public void setDate_update(String date_update) {
		this.date_update = date_update;
	}

	public String getPerson_create() {
		return person_create;
	}

	public void setPerson_create(String person_create) {
		this.person_create = person_create;
	}

}
