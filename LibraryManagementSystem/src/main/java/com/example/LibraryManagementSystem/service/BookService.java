package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.entities.Book;
import com.example.LibraryManagementSystem.repo.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book>getAllBooks(){
        return bookRepository.findAll();
    }
    public Optional<Book>getBookById(Long id){
        return bookRepository.findById(id);
    }
    public Book addBook(Book book){
        return bookRepository.save(book);
    }
    public Book updateBook(Book book,Long id){
        if (bookRepository.existsById(id)) {
            book.setID(id);
            return bookRepository.save(book);
        }
        return null;
    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
