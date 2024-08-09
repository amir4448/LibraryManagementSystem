package com.example.LibraryManagementSystem.repo;

import com.example.LibraryManagementSystem.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
