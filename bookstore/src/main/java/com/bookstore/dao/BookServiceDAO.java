package com.bookstore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bookstore.bean.Book;

@Repository
public interface BookServiceDAO {
	
	public boolean addBook(Book book);
	
	public List<Book> searchBook(int isbn, String title, String author);
	
	public List<Book> buyBook(int isbn);
	
	public List<String> searchMediaCover(String title);
}
