package com.example.LibraryManagementSystem.repo;

import com.example.LibraryManagementSystem.entities.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord,Long> {
    @Query("select br from BorrowingRecord br where br.book.id = :bookId and " +
            "br.patron.id = :patronId and br.returnDate is null")
    Optional<BorrowingRecord> findBookAndPatronById(Long bookId, Long patronId);
}
