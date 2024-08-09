package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.entities.Patron;
import com.example.LibraryManagementSystem.repo.PatronRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatronService {
    private final PatronRepository patronRepository;

    public PatronService(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }
    public List<Patron> getAllPatrons(){
        return patronRepository.findAll();
    }
    public Optional<Patron> getPatronById(Long id){
        return patronRepository.findById(id);
    }
    public Patron addPatron(Patron patron){
        return patronRepository.save(patron);
    }
    public Patron updatePatron(Patron patron, Long id){
        if (patronRepository.existsById(id)){
            patron.setID(id);
            patronRepository.save(patron);
        }
        return null;
    }
    public void deletePatron(Long id){
        patronRepository.deleteById(id);
    }
}
