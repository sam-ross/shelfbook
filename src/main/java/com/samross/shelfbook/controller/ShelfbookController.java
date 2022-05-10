package com.samross.shelfbook.controller;

import com.samross.shelfbook.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShelfbookController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return ResponseEntity.ok(String.format("Hello %s!!", name));
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        final String SQL_QUERY_1 = "SELECT * FROM shelfbook.books";

        List<Book> books = jdbcTemplate.query(
                SQL_QUERY_1,
                (rs, rowNum) ->
                        new Book(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("author")
                        )
        );

        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable int bookId) {
        final String SQL_QUERY_1 = "SELECT * FROM shelfbook.books WHERE id=?";

         Book book = jdbcTemplate.queryForObject(
                SQL_QUERY_1,
                new Object[]{bookId},
                (rs, rowNum) ->
                        new Book(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("author")
                        )
        );

        return ResponseEntity.ok(book);
    }

    @PostMapping("/books")
    public ResponseEntity<String> insertBook(@RequestParam String name, @RequestParam String author) {
        String sql = "INSERT INTO shelfbook.books (name, author) " +
                "VALUES ('" + name + "', '" + author + "')";

        int rows = jdbcTemplate.update(sql);

        if (rows > 0) {
            System.out.println("New row inserted successfully");
        }

//        return ResponseEntity.ok("New row inserted successfully");
//        return new ResponseEntity.of(
//                "asdf",
//                HttpStatus.CREATED
//        );

        return new ResponseEntity<>("New row inserted successfully", HttpStatus.CREATED);
    }
}
