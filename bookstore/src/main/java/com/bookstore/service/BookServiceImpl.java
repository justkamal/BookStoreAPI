package com.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.bean.Book;
import com.bookstore.bean.Post;
import com.bookstore.dao.BookServiceDAO;
import com.bookstore.utility.Trie;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookServiceDAO bookServiceDAO;
	
	@Transactional
	@Override
	public boolean addBook(Book book) {
		return bookServiceDAO.addBook(book);
	}
	
	private boolean sentenceContainsPhrase(String[] sentence, String[] phrase) {
		Trie wordTrie = new Trie();
		for(int w = 0; w < sentence.length; ++w)
			wordTrie.insert(sentence[w].toLowerCase(), w);
		
		int prevIndex = -1, currIndex = -1;
		boolean isPresent = true;
		
		for(int w = 0; w < phrase.length && isPresent; ++w) {
			Integer pos = wordTrie.search(phrase[w].toLowerCase());
			if(pos == null) {
				isPresent = false;
				break;
			}
			if(w == 0) {
				prevIndex = currIndex = pos.intValue();
			} else {
				prevIndex = currIndex;
				currIndex = pos.intValue();
				isPresent &= (currIndex - prevIndex) == 1 ? true : false;
			}
		}
		
		return isPresent;
	}
	
	@Transactional
	@Override
	public List<Book> searchBook(Integer isbn, String title, String author) {
		if (isbn == null && title == null && author == null) {
			System.out.println("Please provide atleast one detail");
			return null;
		} else
			return bookServiceDAO.searchBook(isbn, title, author);
	}

	@Transactional
	@Override
	public Book buyBook(Integer isbn) {
		return bookServiceDAO.buyBook(isbn);
	}

	@Transactional
	@Override
	public List<String> searchMediaCover(String bookTitle) {
		List<String> result = new ArrayList<String>();
		List<Post> posts = bookServiceDAO.getMediaCoverPosts();
		
		for(Post post : posts) {
			String[] postTitleWords = post.getTitle().split(" ");
			String[] bookTitleWords = bookTitle.split(" ");
			
			if(sentenceContainsPhrase(postTitleWords, bookTitleWords)) {
				result.add(post.getTitle());
			} else {
				String[] postBody = post.getBody().replace("\n", " ").split(" ");
				if(sentenceContainsPhrase(postBody, bookTitleWords))
					result.add(post.getTitle());
			}
		}
		
		return result;
	}

}