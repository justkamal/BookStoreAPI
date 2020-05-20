package com.bookstore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bookstore.bean.Book;

@Repository
public class BookServiceDAOImpl implements BookServiceDAO {

	@Override
	public boolean addBook(Book book) {
		System.out.println("Added !");
		return false;
	}

	@Override
	public List<Book> searchBook(int isbn, String title, String author) {
		System.out.println("Searching...");
		return null;
	}

	@Override
	public List<Book> buyBook(int isbn) {
		System.out.println("Adding to book list..");
		return null;
	}

	@Override
	public List<String> searchMediaCover(String title) {
		System.out.println("Searching for Media Cover");
		return null;
	}
}