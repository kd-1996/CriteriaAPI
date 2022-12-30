package com.example.CriterialAPI.DAO;

import com.example.CriterialAPI.entities.Author;
import com.example.CriterialAPI.entities.Book;
import com.example.CriterialAPI.entities.Genre;
import com.example.CriterialAPI.repositories.AuthorRepository;
import com.example.CriterialAPI.repositories.BookRepository;
import com.example.CriterialAPI.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class DaoClass {

    @Autowired
    public EntityManager entityManager;


    @Autowired
    public BookRepository bookRepository;

    @Autowired
    public GenreRepository genreRepository;

    @Autowired
    public AuthorRepository authorRepository;

    public List<Book> getBooksByGenreAndAuthor() {
        //TODO:you want to retrieve all books in a specific genre written by a particular author.

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        //TODO: define JOIN Clauses
        Join<Book, Author> author = root.join("authors");
        Join<Book, Genre> genre = root.join("genres");

        criteriaQuery.where(
                criteriaBuilder.equal(author.get("id"), 6),
                criteriaBuilder.equal(genre.get("id"), 6)
        );

        List<Book> books = entityManager
                .createQuery(criteriaQuery)
                .getResultList();
        return books;
    }

    public void addBooks(Book book) {
        bookRepository.save(book);
    }

    public void addGenre(Genre genre){
        genreRepository.save(genre);
    }

    public void addAuthor(Author author){
        authorRepository.save(author);
    }

}
