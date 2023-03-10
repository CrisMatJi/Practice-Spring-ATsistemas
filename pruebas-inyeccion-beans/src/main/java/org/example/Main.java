package org.example;

import org.example.config.Config;
import org.example.interfaces.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        //Primer Ejemplo
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        HelloService repo = context.getBean(HelloService.class);

        repo.sayHello();









    }
}