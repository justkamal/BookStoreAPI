package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.bean.Book;
import com.bookstore.dao.BookServiceDAO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookServiceDAO bookServiceDAO;

	@Transactional
	@Override
	public boolean addBook(Book book) {
		return bookServiceDAO.addBook(book);
	}

	@Transactional
	@Override
	public List<Book> searchBook(Integer isbn, String title, String author) {
		if(isbn == null && title == null && author == null) {
			System.out.println("Please provide atleast one detail");
			return null;
		} else 
			return bookServiceDAO.searchBook(isbn, title, author);
	}

	@Transactional
	@Override
	public List<Book> buyBook(Integer isbn) {
		return bookServiceDAO.buyBook(isbn);
	}

	@Transactional
	@Override
	public List<String> searchMediaCover(String title) {
		return bookServiceDAO.searchMediaCover(title);
	}

}