package com.study;

import com.data_source.BookGroups;
import com.data_source.UserGroups;
import com.entity.Book;
import com.entity.User;

import java.util.List;

public class Main_book {

    public static void main(String[] args) {
        int userCount = 0;
        int bookCount = 0;

        List<Book> books = BookGroups.getInstance().getBooks();

        List<User> users = UserGroups.getInstance().getUsers();



    }

}
