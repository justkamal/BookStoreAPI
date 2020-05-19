package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BookServiceDAOImpl;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookServiceDAOImpl bookServiceDAOImpl;
	
	@Override
	public boolean addBook(int isbn, String title, String author, float price) {
		bookServiceDAOImpl.addBook(isbn, title, author, price);
		return false;
	}

}