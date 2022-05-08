package com.bookapp.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.exceptions.IdNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.bookapp");
		IBookService bookInter = context.getBean("bookServiceImpl",BookServiceImpl.class);

//		IBookService bookInter = new BookServiceImpl();
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("For Admin Login ----> Enter A");
		System.out.println("For Customer    ----> Enter C");

		String input = scanner.next();
		char key = input.toUpperCase().charAt(0);

		if (key == 'A') {
			System.out.println("Enter 1 to Add Book");
			System.out.println("Enter 2 to Delete Book");
			System.out.println("Enter 3 to Get Book data by Book ID");
			System.out.println("Enter 4 to Update Book");

			int user = scanner.nextInt();

			switch (user) {
			case 1:
				System.out.println("Enter Book ID :");
				int id = scanner.nextInt();

				System.out.println("Enter Book Title :");
				String title = scanner.next();

				System.out.println("Enter Book Author :");
				String author = scanner.next();

				System.out.println("Enter Book Category :");
				String category = scanner.next();

				System.out.println("Enter Book Price :");
				double price = scanner.nextInt();

				bookInter.addBook(new Book(id,title,author,category,price));
				break;
			case 2:
				System.out.println("Enter Book ID -");
				int bookId = scanner.nextInt();
				bookInter.deleteBook(bookId);
				break;
			case 3:
				System.out.println("Enter Book ID -");
				bookId = scanner.nextInt();
				try {
					bookInter.getById(bookId);
				} catch (IdNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Enter the new price");
				price = scanner.nextInt();
				bookId = scanner.nextInt();
				bookInter.updateBook(bookId, price);
				break;

			default:
				System.err.println("--- Invalid Input ---");
				break;
			}

		} else if (key == 'C') {
			System.out.println("Enter 1 to Get All Books Details");
			System.out.println("Enter 2 to Get All Books by Author");
			System.out.println("Enter 3 to Get All Books by Category");
			System.out.println("Enter 4 to Get All Books by Lesser Price");

			int entry = scanner.nextInt();

			switch (entry) {
			case 1:
				for (Book book : bookInter.getAll()) {
					System.out.println(book);
				}

				break;

			case 2:
				System.out.println("Enter Author name :");
				String author = scanner.next();
				try {
					for (Book book : bookInter.getByAuthor(author)) {
						System.out.println(book);
					}
				} catch (BookNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Enter Author name :");
				String category = scanner.next();
				try {
					for (Book book : bookInter.getByCategory(category)) {
						System.out.println(book);
					}
				} catch (BookNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Enter a price :");
				double price = scanner.nextDouble();
				try {
					for (Book book : bookInter.getByLesserPrice(price)) {
						System.out.println(book);
					}
				} catch (BookNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;

			default:
				System.err.println("--- Invalid Input ---");
				break;
			}
		} else {
			System.err.println("Invalid Entry");
		}
	}
}
