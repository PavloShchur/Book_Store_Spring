package com.books.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Author")
public class Author extends AbstractEntity {

	/* @Column(unique=true) */
	@Column(name = "Name")
	private String name;
	@Column(name = "Surname")
	private String surname;
	
	@ManyToMany
	@JoinTable(name = "AuthorBook", joinColumns = @JoinColumn(name = "AuthorID"), 
	inverseJoinColumns = @JoinColumn(name = "BookID"))
	private List<Book> books;

	public Author() {
	}

	public Author(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", surname=" + surname + "]";
	}
	
	

}
