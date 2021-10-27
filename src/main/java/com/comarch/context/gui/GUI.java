package com.comarch.context.gui;

import com.comarch.context.authentication.Authentication;
import com.comarch.context.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class GUI {
    @Autowired
    UserRepository userRepository;
    @Autowired
    Authentication authentication;

    public void startApp() throws IOException {
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String choose = br.readLine();

        switch (choose) {
            case "1":
                register();
                startApp();
                break;
            case "2":
                login();
                startApp();
                break;
            case "3":
                System.exit(0);
            default:
                System.out.println("Nieprawidlowy wybor !!");
                startApp();
        }
    }

    private void register() throws IOException {
        System.out.println("Podaj login:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String login = br.readLine();
        System.out.println("Podaj haslo:");
        String pass = br.readLine();

        this.userRepository.addUser(login, pass);

        System.out.println("User dodany !!");
    }

    private void login() throws IOException {
        System.out.println("Podaj login:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String login = br.readLine();
        System.out.println("Podaj haslo:");
        String pass = br.readLine();

        boolean authResult = authentication.authenticate(login, pass);
        if(authResult) {
            System.out.println("Zalogowano");
        } else  {
            System.out.println("Nieprawidłowe dane");
        }
    }
}
