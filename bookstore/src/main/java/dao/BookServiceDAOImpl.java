package dao;

import javax.annotation.Resource;

@Resource
public class BookServiceDAOImpl implements BookServiceDAO {

	@Override
	public boolean addBook(int isbn, String title, String author, float price) {
		System.out.println("Added !");
		return false;
	}

}