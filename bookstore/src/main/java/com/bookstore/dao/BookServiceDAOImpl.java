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

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> searchBook(Integer isbn, String title, String author) {
		Session current = entityManager.unwrap(Session.class);
		Query result = null;

		StringBuilder query = new StringBuilder("FROM Book WHERE ");

		if (isbn != null) {
			query.append("isbn = " + isbn);
		}
		if (title != null) {
			if(isbn != null)
				query.append(" AND ");
			query.append(" title LIKE '%" + title + "%'");
		}
		if (author != null) {
			if(title != null)
				query.append(" AND ");
			query.append(" author LIKE '%" + author + "%'");
		}

		result = current.createQuery(query.toString()).setMaxResults(100);

		List<Book> bookList = result.list();
		System.out.println(bookList);
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