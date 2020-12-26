package com.company.service;

import com.company.model.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);
    void removeBook(String id);
    List<Book> getBooks();

}
