package com.company;

import com.company.dao.BookDao;
import com.company.dao.BookDaoImpl;
import com.company.model.Book;
import com.company.service.BookService;
import com.company.service.BookServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        BookDao bookDao = new BookDaoImpl();
        BookService bookService = new BookServiceImpl(bookDao);

        while (true) {
            print();
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            if (input == 1) {
                List<Book> books = bookService.getBooks();
                for(Book book : books) {
                    System.out.println("title :" + book.getTitle() + ", author :" + book.getAuthor() + ", pages:" + book.getPages());
                }
            } else if (input == 2) {
                System.out.println("შეიყვანეთ აიდი:");
                String id = scanner.nextLine();
                System.out.println("შეიყვანეთ სახელი:");
                String name = scanner.nextLine();
                System.out.println("შეიყვანეთ ავტორი:");
                String author = scanner.nextLine();
                System.out.println("შეიყვანეთ გვერდების რაოდენობა:");
                int pages = scanner.nextInt();
                bookService.addBook(new Book(id,name,author,pages));
            } else if (input == 3) {
                System.out.println("შეიყვანეთ აიდი:");
                String id = scanner.nextLine();
                bookService.removeBook(id);
            } else break;
        }

    }

    static void print() {
        System.out.println("1 - წიგნების ნახვა");
        System.out.println("2 - წიგნის დამატება");
        System.out.println("3 - წიგნის წაშლა");
    }

}
