package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service.BookServiceImpl;

@RestController
@RequestMapping("/api")
public class RESTController {

	@Autowired
	private BookServiceImpl bookServiceImpl;

	@PutMapping("/addBook")
	public void addBook(@RequestParam("id") int isbn, @RequestParam("title") String title,
			@RequestParam("author") String author, @RequestParam("price") float price) {
		bookServiceImpl.addBook(isbn, title, author, price);
	}
	
}