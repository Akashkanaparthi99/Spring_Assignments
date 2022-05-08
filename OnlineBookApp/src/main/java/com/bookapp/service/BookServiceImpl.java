package com.bookapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.IBookDao;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;

@Service
public class BookServiceImpl implements IBookService {

	private IBookDao bookDao;
	@Autowired
	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public void addBook(Book book) {
		// from the service calling the method of the bookDao
		bookDao.addBook(book);

	}

	@Override
	public void updateBook(int bookId, double price) {
		bookDao.updateBook(bookId, price);
	}

	@Override
	public void deleteBook(int bookId) {
		bookDao.deleteBook(bookId);
	}

	@Override
	public Book getById(int bookId) throws IdNotFoundException {
		Book book = bookDao.findById(bookId);
		if (book == null) {
			throw new IdNotFoundException("Invalid ID");
		}
		return book;
	}

	@Override
	public List<Book> getAll() {
		List<Book> books = bookDao.findAll();

		return books.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
	}

	@Override
	public List<Book> getByAuthor(String author) throws BookNotFoundException {
		List<Book> booksByAuthor = bookDao.findByAuthor(author);
		if (booksByAuthor.isEmpty()) {
			throw new BookNotFoundException("Books By the " + author + " are not AVAILABLE...!");
		}
		return booksByAuthor.stream().sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> booksByCategory = bookDao.findByCategory(category);
		if (booksByCategory.isEmpty()) {
			throw new BookNotFoundException("Books in the " + category + " are not PRESENT..!!");
		}
		return booksByCategory.stream().sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Book> getByLesserPrice(double price) throws BookNotFoundException {
		List<Book> booksByLessPrice = bookDao.findByLesserPrice(price);
		if (booksByLessPrice.isEmpty()) {
			throw new BookNotFoundException("Books by the price range below ->" + price + " not found");
		}
		return booksByLessPrice.stream().sorted((o1, o2) -> o1.getTitle().compareTo(o2.getTitle()))
				.collect(Collectors.toList());
	}

}
