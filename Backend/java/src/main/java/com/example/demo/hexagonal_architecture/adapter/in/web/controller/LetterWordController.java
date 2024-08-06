package com.example.demo.hexagonal_architecture.adapter.in.web.controller;

import com.example.demo.hexagonal_architecture.core.enitity.LetterWordEntity;
import com.example.demo.hexagonal_architecture.core.service.LetterWordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/letter-words")
public class LetterWordController {

    @Autowired
    private LetterWordServiceImpl letterWordServiceImpl;

    @PostMapping
    public ResponseEntity<LetterWordEntity> createLetterWord(@RequestBody LetterWordEntity letterWordEntity) {
        try {
            LetterWordEntity savedLetterWordEntity = letterWordServiceImpl.saveLetterWord(letterWordEntity);
            return new ResponseEntity<>(savedLetterWordEntity, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<LetterWordEntity> getLetterWord(@PathVariable Long id) {
        try {
            LetterWordEntity letterWordEntity = letterWordServiceImpl.getLetterWordById(id);
            return new ResponseEntity<>(letterWordEntity, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLetterWord(@PathVariable Long id) {
        try {
            letterWordServiceImpl.deleteLetterWord(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}