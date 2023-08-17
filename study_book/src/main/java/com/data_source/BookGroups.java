package com.data_source;

import com.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookGroups {

    private static BookGroups instance;
    private List<Book> books;
    private static final Object lock = new Object();

    public BookGroups() {
        this.books = new ArrayList<>();
    }

    public static BookGroups getInstance(){
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new BookGroups();
                }
            }
        }
        return instance;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(Book book) {
        this.books.add(book);
    }
}
