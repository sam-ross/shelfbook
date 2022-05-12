package com.samross.shelfbook.controller;

import com.samross.shelfbook.Book;
import com.samross.shelfbook.dao.ShelfbookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShelfbookController {
    @Autowired
    private ShelfbookDao shelfbookDao;

    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return ResponseEntity.ok(String.format("Hello %s!!", name));
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = shelfbookDao.getBooks();

        return ResponseEntity.ok(books);
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable int bookId) {
        List<Book> books = shelfbookDao.getBookById(bookId);

        if (books.size() == 1) {
            return ResponseEntity.ok(books.get(0));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/books")
    public ResponseEntity<String> insertBook(@RequestParam String name, @RequestParam String author) {
        int rows = shelfbookDao.insertBook(name, author);

        if (rows == 1) {
            return new ResponseEntity<>("New row inserted successfully", HttpStatus.CREATED);
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<String> updateBook(
            @PathVariable int bookId, @RequestParam String name, @RequestParam String author
    ) {
        int rows = shelfbookDao.updateBook(bookId, name, author);

        if (rows == 1) {
            return ResponseEntity.ok("Book updated successfully");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable int bookId) {
        int rows = shelfbookDao.deleteBook(bookId);

        if (rows == 1) {
            return ResponseEntity.ok("Book deleted successfully");
        }

        return ResponseEntity.notFound().build();
    }
}
