package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bean.Book;
import com.bookstore.dao.BookServiceDAO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookServiceDAO bookServiceDAO;

	@Override
	public boolean addBook(Book book) {
		bookServiceDAO.addBook(book);
		return false;
	}

	@Override
	public List<Book> searchBook(Integer isbn, String title, String author) {
		if(isbn == null && title == null && author == null)
			System.out.println("Please provide atleast one detail");
		else 
			return bookServiceDAO.searchBook(isbn.intValue(), title, author);
		return null;
	}

	@Override
	public List<Book> buyBook(int isbn) {
		bookServiceDAO.buyBook(isbn);
		return null;
	}

	@Override
	public List<String> searchMediaCover(String title) {
		bookServiceDAO.searchMediaCover(title);
		return null;
	}

}