package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.entities.Patron;
import com.example.LibraryManagementSystem.service.PatronService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {
    private final PatronService patronService;

    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    @GetMapping
    public ResponseEntity<List<Patron>> getAllPatrons(){
        return ResponseEntity.ok(patronService.getAllPatrons());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Patron> getPatronById(@PathVariable Long id){
        return patronService.getPatronById(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Patron> addPatron(@Validated @RequestBody Patron patron){
        return new ResponseEntity<>(patronService.addPatron(patron),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Patron> updatePatron(@PathVariable Long id, @Validated @RequestBody Patron patron){
        Patron updatedPatron=patronService.updatePatron(patron, id);
        if (updatedPatron != null){
            return ResponseEntity.ok(updatedPatron);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Patron> deletePatron(@PathVariable Long id){
        patronService.deletePatron(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
