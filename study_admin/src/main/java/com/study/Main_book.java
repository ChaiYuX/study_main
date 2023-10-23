package com.study;

import com.data_source.BookGroups;
import com.data_source.UserGroups;
import com.entity.Book;
import com.entity.User;
import com.proxyp.UserInvocationHandler;

import java.lang.reflect.Proxy;
import java.util.List;

public class Main_book {

    public static void main(String[] args) {
        int userCount = 0;
        int bookCount = 0;

        List<Book> books = BookGroups.getInstance().getBooks();
        Book b1 = new Book();


        List<User> users = UserGroups.getInstance().getUsers();

        User u1 = new User("张三" , true);

        // 代理类
        UserInvocationHandler handler = new UserInvocationHandler(u1);
        User proxy = (User)Proxy.newProxyInstance(
                u1.getClass().getClassLoader(),
                u1.getClass().getInterfaces(),
                handler
        );
        proxy.read(b1);
    }

}
