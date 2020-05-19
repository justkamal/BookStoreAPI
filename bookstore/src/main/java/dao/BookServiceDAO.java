package dao;

import javax.annotation.Resource;

@Resource
public interface BookServiceDAO {
	
	public boolean addBook(int isbn, String title, String author, float price);
	
}
