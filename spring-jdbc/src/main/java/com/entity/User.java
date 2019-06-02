package com.entity;


public class User  {

	private String id;

	private String name;

	public User() {
	}

	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
       /* return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);*/
	        return String.format(
	                "User[id=%s, name='%s']",
	                id, name);
	    
    }

}