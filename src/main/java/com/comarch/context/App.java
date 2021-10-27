package com.comarch.context;

import com.comarch.context.configuration.AppConfiguration;
import com.comarch.context.gui.GUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        GUI gui = context.getBean(GUI.class);

        gui.startApp();
    }
}
