package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bean.Book;
import com.bookstore.service.BookService;

@RestController
@RequestMapping("/api")
public class BookStoreController {

	@Autowired
	private BookService bookService;

	@PutMapping("/addBook")
	public void addBook(Book book) {
		bookService.addBook(book);
		System.out.println(book);
	}
	
	@GetMapping("/searchBook")
	public List<Book> searchBook(@RequestParam(value = "ISBN", required = false) Integer isbn, 
								 @RequestParam(value = "title", required = false) String title,
								 @RequestParam(value = "author", required = false) String author) {
		return bookService.searchBook(isbn, title, author);
	}
	
	@PutMapping("/buyBook")
	public List<Book> buyBook(@RequestParam("ISBN") int isbn){
		return bookService.buyBook(isbn);
	}
	
	@GetMapping("/searchForMediaCover")
	public List<String> searchMediaCover(@RequestParam("title") String title){
		return bookService.searchMediaCover(title);
	}
}