package com.samross.shelfbook.dao;

import com.samross.shelfbook.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShelfbookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> getBooks() {
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

        return books;
    }

    public List<Book> getBookById(int bookId) {
        final String SQL_QUERY_1 = "SELECT * FROM shelfbook.books WHERE id=?;";

        List<Book> books = jdbcTemplate.query(
                SQL_QUERY_1,
                new Object[]{bookId},
                (rs, rowNum) ->
                        new Book(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("author")
                        )
        );

        return books;
    }


    public int insertBook(String name, String author) {
        String sql = "INSERT INTO shelfbook.books (name, author) " +
                "VALUES ('" + name + "', '" + author + "')";

        return jdbcTemplate.update(sql);
    }

    public int updateBook(int bookId, String name, String author) {
        String sql = "UPDATE shelfbook.books " +
                "SET name='" + name + "', author='" + author + "' " +
                "WHERE id=" + bookId + ";";

        return jdbcTemplate.update(sql);
    }

    public int deleteBook(int bookId) {
        String sql = "DELETE FROM shelfbook.books WHERE id=" + bookId + ";";

        return jdbcTemplate.update(sql);
    }


}
