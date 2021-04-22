package ma.fstt.dao;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.model.Book;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		
		BaseBook baseBook = new BaseBook();
		
		baseBook.save(new Book(0,"math" , "toto" , "2020"));
	List<Book> malist = 	baseBook.getAll();
	
	
	for (Book book : malist) {
		
		System.out.println(book.getName());
		
	}
	
	System.out.println(baseBook.getOne(1).getName());
		
		// TODO Auto-generated method stub

	}

}
