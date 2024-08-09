package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.entities.BorrowingRecord;
import com.example.LibraryManagementSystem.service.BorrowingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BorrowController {
    private final BorrowingService borrowingService;

    public BorrowController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }
    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecord> borrowBook(@PathVariable Long bookId,
                                                      @PathVariable Long patronId) {
        BorrowingRecord record = borrowingService.borrowBook(bookId, patronId);
        if (record != null) {
            return new ResponseEntity<>(record, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecord> returnBook(@PathVariable Long bookId,
                                                      @PathVariable Long patronId) {
        BorrowingRecord record = borrowingService.returnBook(bookId, patronId);
        if (record != null) {
            return ResponseEntity.ok(record);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
