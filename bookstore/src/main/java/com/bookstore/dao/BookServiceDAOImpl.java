package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookstore.bean.Book;

@Repository
public class BookServiceDAOImpl implements BookServiceDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public boolean addBook(Book book) {
		Session current = entityManager.unwrap(Session.class);
		current.save(book);
		return true;
	}

	@Override
	public List<Book> searchBook(Integer isbn, String title, String author) {
		Session current = entityManager.unwrap(Session.class);
		Query result = null;
		if(isbn != null)
			result = current.createQuery("FROM book WHERE isbn = " + isbn);
		else if(title != null && author != null)
			result = current.createQuery("FROM book WHERE title LIKE %" + title + "% AND author LIKE %" + author + "% LIMIT 100");
		else if(title != null)
			result = current.createQuery("FROM book WHERE title LIKE %" + title + "% LIMIT 100");
		else if(author != null)
			result = current.createQuery("FROM book WHERE author LIKE %" + author + "% LIMIT 100");
		List<Book> bookList = result.list();
		return bookList;
	}

	@Override
	public List<Book> buyBook(Integer isbn) {
		
		return null;
	}

	@Override
	public List<String> searchMediaCover(String title) {
		System.out.println("Searching for Media Cover");
		return null;
	}
}