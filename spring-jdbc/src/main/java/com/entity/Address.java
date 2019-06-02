package com.entity;

public class Address {
	private String id;
	private String detail;
	private User user;
	public Address() {
	}
	public Address(String id, String detail, User user) {
		this.id = id;
		this.detail = detail;
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
