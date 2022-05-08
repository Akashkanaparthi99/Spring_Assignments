package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.model.Book;
import com.bookapp.util.AllQueries;
import org.springframework.stereotype.Component;

@Component
public class BookDaoImpl implements IBookDao {
	private static Connection connection;

	@Override
	public void addBook(Book book) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		try {

			preparedStatement = connection.prepareStatement(AllQueries.INSERTQUERY);
			preparedStatement.setInt(4, book.getBookId());
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setString(3, book.getCategory());
			preparedStatement.setDouble(5, book.getPrice());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			ConnectionUtil.closeConnection();
		}

	}

	@Override
	public void updateBook(int bookId, double price) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.UPDATEQUERY);
			preparedStatement.setDouble(1, price);
			preparedStatement.setInt(2, bookId);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			ConnectionUtil.closeConnection();
		}
	}

	@Override
	public void deleteBook(int bookId) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.DELETEQUERY);
			preparedStatement.setInt(1, bookId);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			ConnectionUtil.closeConnection();
		}
	}

	@Override
	public Book findById(int bookId) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		Book book = null;
		try {
			preparedStatement = connection.prepareStatement(AllQueries.SELECTIONQUERY);
			preparedStatement.setInt(1, bookId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				String category = resultSet.getString("category");
				double price = resultSet.getDouble("price");
				book = new Book(bookId, title, author, category, price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			ConnectionUtil.closeConnection();
		}
		return book;
	}

	@Override
	public List<Book> findAll() {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Book> bookList = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.SELECTQUERY);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				String category = resultSet.getString("category");
				double price = resultSet.getDouble("price");
				int bookId = resultSet.getInt("bookId");
				Book book = new Book(bookId, title, author, category, price);
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			ConnectionUtil.closeConnection();
		}
		return bookList;
	}

	@Override
	public List<Book> findByAuthor(String author) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Book> bookList = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.AUTHORQUERY);
			preparedStatement.setString(1, author);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String title = resultSet.getString("title");
				String category = resultSet.getString("category");
				double price = resultSet.getDouble("price");
				int bookId = resultSet.getInt("bookId");
				Book book = new Book(bookId, title, author, category, price);
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			ConnectionUtil.closeConnection();
		}
		return bookList;
	}

	@Override
	public List<Book> findByCategory(String category) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Book> bookList = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.CATEGORYQUERY);
			preparedStatement.setString(1, category);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				double price = resultSet.getDouble("price");
				int bookId = resultSet.getInt("bookId");
				Book book = new Book(bookId, title, author, category, price);
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			ConnectionUtil.closeConnection();
		}
		return bookList;
	}

	@Override
	public List<Book> findByLesserPrice(double price) {
		connection = ConnectionUtil.openConnection();
		PreparedStatement preparedStatement = null;
		List<Book> bookList = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(AllQueries.PRICEQUERY);
			preparedStatement.setDouble(1, price);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				String category = resultSet.getString("category");
				int bookId = resultSet.getInt("bookId");
				double nprice = resultSet.getDouble("price");
				Book book = new Book(bookId, title, author, category, nprice);
				bookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			ConnectionUtil.closeConnection();
		}
		return bookList;
	}

}
