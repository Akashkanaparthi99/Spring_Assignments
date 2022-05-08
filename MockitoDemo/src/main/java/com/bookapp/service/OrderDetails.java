package com.bookapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public class OrderDetails {

	// depend on IBookService
	IBookService bookService;
	public List<Book> findByAuthor(String author) throws BookNotFoundException{
		List<Book> books =  bookService.getByAuthor(author);
		if (books!=null) {
				if (books.isEmpty())
					throw new BookNotFoundException();
				return books.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
		}else{
		return null;
		}
	}
	
	public String orderBook(int bookId) throws BookNotFoundException {
		try {
		Book book = bookService.getById(bookId);
		if (book == null) {
			return "Book Not Ordered";
		}
		else {
			return "Ordered successfully";
		}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "Technical Error";
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	public String addBook(Book book1) {
		// TODO Auto-generated method stub
		bookService.addBook(book1);
		if (book1 == null) {
			return "Null Book";
		}
		return "Book added";
	}
}
