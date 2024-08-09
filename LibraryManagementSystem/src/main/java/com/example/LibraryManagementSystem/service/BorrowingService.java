package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.entities.Book;
import com.example.LibraryManagementSystem.entities.BorrowingRecord;
import com.example.LibraryManagementSystem.entities.Patron;
import com.example.LibraryManagementSystem.repo.BookRepository;
import com.example.LibraryManagementSystem.repo.BorrowingRecordRepository;
import com.example.LibraryManagementSystem.repo.PatronRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class BorrowingService {
    private final BorrowingRecordRepository borrowingRecordRepository;
    private final BookRepository bookRepository;
    private final PatronRepository patronRepository;

    public BorrowingService(BorrowingRecordRepository borrowingRecordRepository,
                            BookRepository bookRepository,
                            PatronRepository patronRepository) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.bookRepository = bookRepository;
        this.patronRepository = patronRepository;
    }
    public BorrowingRecord borrowBook(Long bookId,Long patronId){
        Optional<Book>book=bookRepository.findById(bookId);
        Optional<Patron>patron=patronRepository.findById(patronId);

        if (book.isPresent()&&patron.isPresent()){
            BorrowingRecord record=new BorrowingRecord();
            record.setBook(book.get());
            record.setPatron(patron.get());
            record.setBorrowDate(LocalDate.now());
            return borrowingRecordRepository.save(record);
        }
        return null;
    }
    public BorrowingRecord returnBook(Long bookId,Long patronId){
        Optional<BorrowingRecord> record=borrowingRecordRepository.findBookAndPatronById(bookId,patronId);
        if (record.isPresent()){
            BorrowingRecord borrowingRecord=record.get();
            borrowingRecord.setReturnDate(LocalDate.now());
            return borrowingRecordRepository.save(borrowingRecord);
        }
        return null;
    }
}
