package com.samross.shelfbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ShelfbookApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ShelfbookApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        String sql = "INSERT INTO shelfbook.books (name, author) " +
//                "VALUES ('Dear diary', 'sross')";
//
//        int rows = jdbcTemplate.update(sql);
//
//        if (rows > 0) {
//            System.out.println("New row inserted successfully");
//        }
    }
}
