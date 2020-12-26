package com.company.dao;

import com.company.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    void addBook(Book book) throws SQLException;
    void removeBook(String id) throws SQLException;
    List<Book> getBooks() throws SQLException;
}
