package com.testcases.bookapp;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class OrderDetailsTest {

	@InjectMocks
	OrderDetails orderDetails = null;

	@Mock
	IBookService bookService ; // creating proxy of bookservice

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	Book book1, book2, book3, book4, book5;

	@BeforeEach
	void setUp() throws Exception {
//		orderDetails = new OrderDetails();
//		orderDetails.setBookService(bookService);
		
		
		book1 = new Book(1,"Java","Kathy",900);
		book2 = new Book(2,"Css","Kathy",200);
		book3 = new Book(3,"Seven Habits","Steve",300);
		book4 = new Book(4,"5am club","Robin",800);
		book5 = new Book(5,"Spring","Kathy",1000);

	}

	@AfterEach
	void tearDown() throws Exception {
		orderDetails = null;
	}

	@Test
	@DisplayName("Testing by Author")
	void testBookByAuthor() throws BookNotFoundException {
		String author = "Kathy";
		// mock the method and assume it returns a list of books by author
		when(bookService.getByAuthor(author)).thenReturn(Arrays.asList(book1, book4));
		// after getting the data , test the method of OrderDetails
		List<Book> books = orderDetails.findByAuthor(author);
		assertNotNull(books);
//		List<Book> expec = Arrays.asList(book1, book4);
//		assertEquals(expec.toString(), books.toString());
	}

	@Test
	@DisplayName("Testing By Author - returning null")
	void testFindByAuthorNull() throws BookNotFoundException {
		String author = "Kathy";
		// mock the method and assume it returns null
		when(bookService.getByAuthor(author)).thenReturn(null);
		// if null/empty throw exception
		List<Book> books = orderDetails.findByAuthor(author);
		assertNull(books);
	}
	
	@Test
	void testByAuthorEmpty() throws BookNotFoundException {
		String author = "Kathy";
		when(bookService.getByAuthor(author)).thenReturn(new ArrayList<Book>());
		assertThrows(BookNotFoundException.class, ()->orderDetails.findByAuthor(author));
	}

	@Test
	void testByAuthorException() throws BookNotFoundException {
		String author = "Paul";
		when(bookService.getByAuthor(author)).thenThrow(new BookNotFoundException());
		assertThrows(BookNotFoundException.class, ()->orderDetails.findByAuthor(author));
	}
	
	@Test
	@DisplayName("Testing Verify")
	void testVerify() throws BookNotFoundException {
		String author = "Kathy";
		List<Book> expec = Arrays.asList(book2,book1,book5);
		
		
		when(bookService.getByAuthor(author)).thenReturn(Arrays.asList(book1, book2, book5));
		List<Book> actualList = orderDetails.findByAuthor(author);
		assertEquals(expec.toString(), actualList.toString());
		assertNotNull(actualList);
		
		when(bookService.getByAuthor(author)).thenReturn(null);
		List<Book> actual = orderDetails.findByAuthor(author);
		assertNull(actual);
		
		Mockito.verify(bookService,times(2)).getByAuthor(author);
		Mockito.verify(bookService,atLeastOnce()).getByAuthor(author);
		Mockito.verify(bookService,atLeast(2)).getByAuthor(author);
	}
}
