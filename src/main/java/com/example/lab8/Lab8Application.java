package com.example.lab8;

import com.example.lab8.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab8Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Lab8Application.class, args);
    }
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception {

    }
}
