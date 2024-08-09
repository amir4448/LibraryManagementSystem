package com.example.LibraryManagementSystem;

import com.example.LibraryManagementSystem.entities.Patron;
import com.example.LibraryManagementSystem.repo.PatronRepository;
import com.example.LibraryManagementSystem.service.PatronService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PatronServiceTest {
    @Mock
    private PatronRepository patronRepository;

    @InjectMocks
    private PatronService patronService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPatronById() {
        Patron patron = new Patron(1L, "John Doe", "johndoe@example.com");
        when(patronRepository.findById(1L)).thenReturn(Optional.of(patron));

        Optional<Patron> foundPatron = patronService.getPatronById(1L);

        assertTrue(foundPatron.isPresent());
        assertEquals("John Doe", foundPatron.get().getName());
    }

    @Test
    void testAddPatron() {
        Patron patron = new Patron(1L, "John Doe", "johndoe@example.com");
        when(patronRepository.save(patron)).thenReturn(patron);

        Patron savedPatron = patronService.addPatron(patron);

        assertNotNull(savedPatron);
        assertEquals("John Doe", savedPatron.getName());
    }
}
