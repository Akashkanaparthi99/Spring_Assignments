package com.bookapp.service;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {

	List<Book> getByAuthor(String author) throws BookNotFoundException;
	List<Book> getByLessPrice(double price);
	Book getById(int bookId) throws BookNotFoundException;
	void addBook(Book book);
	
}
