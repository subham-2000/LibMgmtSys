package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.model.Author;
import com.example.librarymanagementsystem.model.AuthorCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, AuthorCompositeKey> {
    Author findByEmail(String email);
}
