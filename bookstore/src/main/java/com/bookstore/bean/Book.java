package com.bookstore.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	@Id
	@Column
	private int isbn;
	
	@Column
	private String title;
	
	@Column
	private String author;
	
	@Column
	private float price;
	
	public Book() {
		
	}
	
	public Book(Book book) {
		super();
		this.isbn = book.isbn;
		this.title = book.title;
		this.author = book.author;
		this.price = book.price;
	}

	public int getIsbn() {
		return isbn;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}
