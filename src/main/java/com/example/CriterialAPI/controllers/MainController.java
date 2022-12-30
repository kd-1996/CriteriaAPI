package com.example.CriterialAPI.controllers;

import com.example.CriterialAPI.DAO.DaoClass;
import com.example.CriterialAPI.entities.Author;
import com.example.CriterialAPI.entities.Book;
import com.example.CriterialAPI.entities.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private DaoClass daoClass;

    @PostMapping("v1/add/book")
    public void addBooks(@RequestBody Book book) {
        daoClass.addBooks(book);

    }

    @PostMapping("v1/add/author")
    public void addAuthor(@RequestBody Author author) {
        daoClass.addAuthor(author);
    }

    @PostMapping("v1/add/genre")
    public void addGenre(@RequestBody Genre genre) {
        daoClass.addGenre(genre);
    }

    @GetMapping("v1/get")
    public List<Book> getBooksByGenreAndAuthor(){
         return daoClass.getBooksByGenreAndAuthor();
    }
}
