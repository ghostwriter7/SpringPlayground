package com.rozplochowski.aspectorientedprogramming;

import com.rozplochowski.aspectorientedprogramming.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectOrientedProgrammingApplication {

    static void main(String[] args) {
        try (var ctx = new AnnotationConfigApplicationContext(Config.class)) {

        }
    }

}
