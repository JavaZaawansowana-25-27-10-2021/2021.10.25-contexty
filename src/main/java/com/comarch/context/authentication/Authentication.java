package com.comarch.context.authentication;

import com.comarch.context.database.UserRepository;
import com.comarch.context.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Authentication {
    @Autowired
    UserRepository userRepository;

    public boolean authenticate(String login, String pass) {
        User user = userRepository.getUserByLogin(login);
        return user != null && user.getPass().equals(pass);
    }
}
