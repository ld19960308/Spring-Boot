package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book{

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	@Column(name="name")
	private String name;

	//bi-directional many-to-one association to Author
	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author;

	public Book() {
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

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}
