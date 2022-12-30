package com.example.CriterialAPI.repositories;

import com.example.CriterialAPI.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
