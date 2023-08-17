package com.data_source;

import com.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserGroups {

    private static volatile UserGroups instance;
    private List<User> users;

    private static final Object lock = new Object();

    public UserGroups() {
        users = new ArrayList<>();
    }

    public static UserGroups getInstance(){
        if (instance == null){
            synchronized (lock){
                if (instance == null) {
                    instance = new UserGroups();
                }
            }
        }
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(User user) {
        this.users.add(user);
    }

}
