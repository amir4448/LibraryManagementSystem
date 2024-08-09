package com.example.LibraryManagementSystem;

import com.example.LibraryManagementSystem.entities.Book;
import com.example.LibraryManagementSystem.repo.BookRepository;
import com.example.LibraryManagementSystem.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBooks() {
        Book book1 = new Book(1L, "Book 1", "Author 1", 2020,"1234567890");
        Book book2 = new Book(2L, "Book 2", "Author 2",  2021,"0987654321");
        when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        List<Book> books = bookService.getAllBooks();

        assertNotNull(books);
        assertEquals(2, books.size());
        assertEquals("Book 1", books.get(0).getTitle());
    }

    @Test
    void testGetBookById() {
        Book book = new Book(1L, "Book 1", "Author 1", 2020,"1234567890");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        Optional<Book> foundBook = bookService.getBookById(1L);

        assertTrue(foundBook.isPresent());
        assertEquals("Book 1", foundBook.get().getTitle());
    }

    @Test
    void testAddBook() {
        Book book = new Book(1L, "New Book", "New Author",2022, "1234567890");
        when(bookRepository.save(book)).thenReturn(book);

        Book savedBook = bookService.addBook(book);

        assertNotNull(savedBook);
        assertEquals("New Book", savedBook.getTitle());
    }
}
