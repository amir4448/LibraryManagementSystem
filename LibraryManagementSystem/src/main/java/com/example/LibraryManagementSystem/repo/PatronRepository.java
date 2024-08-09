package com.example.LibraryManagementSystem.repo;

import com.example.LibraryManagementSystem.entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepository extends JpaRepository<Patron,Long> {
}
