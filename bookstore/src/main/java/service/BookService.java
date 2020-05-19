package service;

import org.springframework.stereotype.Service;

@Service
public interface BookService {
	
	public boolean addBook(int isbn, String title, String author, float price);
	
}
