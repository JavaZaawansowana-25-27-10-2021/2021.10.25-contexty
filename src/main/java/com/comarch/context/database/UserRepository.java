package com.comarch.context.database;

import com.comarch.context.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        this.users.add(new User("janusz", "janusz"));
        this.users.add(new User("zbyszek", "zbyszek"));
        this.users.add(new User("admin", "admin"));
    }

    public void addUser(String login, String pass) {
        User user = new User(login, pass);
        this.users.add(user);
    }

    public User getUserByLogin(String login) {
        for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }

        return null;
    }

    public List<User> getUsers() {
        return users;
    }
}
