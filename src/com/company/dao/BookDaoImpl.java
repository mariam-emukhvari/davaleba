package com.company.dao;

import com.company.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao{

    private Connection connection;

    public BookDaoImpl() throws SQLException {
        Driver driver = new org.h2.Driver();
        DriverManager.registerDriver(driver);

        connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

    @Override
    public void addBook(Book book) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO book VALUES (?, ?, ?, ?)");
        preparedStatement.setString(1, book.getId());
        preparedStatement.setString(2, book.getTitle());
        preparedStatement.setString(3, book.getAuthor());
        preparedStatement.setInt(4, book.getPages());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void removeBook(String id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM system_user WHERE id = " + id);
        statement.close();
    }

    @Override
    public List<Book> getBooks() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM book");

        List<Book> list = new ArrayList<>();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            int pages = resultSet.getInt("pages");
            list.add(new Book(id, title, author, pages));
        }

        statement.close();

        return list;
    }
}
