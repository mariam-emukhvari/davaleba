package com.company.service;

import com.company.dao.BookDao;
import com.company.model.Book;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao dao;

    public BookServiceImpl(BookDao dao) {
        this.dao = dao;
    }

    @Override
    public void addBook(Book book) {
        try {
            dao.addBook(book);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void removeBook(String id) {
        try {
            dao.removeBook(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Book> getBooks() {
        try {
            return dao.getBooks();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
