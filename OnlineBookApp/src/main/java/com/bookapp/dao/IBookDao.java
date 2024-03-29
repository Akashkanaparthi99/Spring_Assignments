package com.bookapp.dao;

import java.util.List;

import com.bookapp.model.Book;

public interface IBookDao {
	
	//Admin
	void addBook(Book book);

	void updateBook(int bookId, double price);

	void deleteBook(int bookId);

	Book findById(int bookId);

	//customers
	List<Book> findAll();

	List<Book> findByAuthor(String author);

	List<Book> findByCategory(String category);

	List<Book> findByLesserPrice(double price);
}
