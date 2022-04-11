package kr.ac.kopo.bookstore.dao;

import java.util.List;

import kr.ac.kopo.bookstore.model.Book;

public interface BookDao {

	List<Book> list();

	void add(Book item);

	Book item(int bookid);

	void update(Book item);

	void delete(int code);

}
