package com.example.CriterialAPI.repositories;

import com.example.CriterialAPI.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
