package com.example.demo.hexagonal_architecture.adapter.in.web.controller;

import com.example.demo.hexagonal_architecture.core.enitity.guessTheWordsEntity.Letter;
import com.example.demo.hexagonal_architecture.core.enitity.guessTheWordsEntity.Word;
import com.example.demo.hexagonal_architecture.core.service.SlagalicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/slagalica")
public class SlagalicaController {

    private final SlagalicaService slagalicaService;

    public SlagalicaController(SlagalicaService slagalicaService) {
        this.slagalicaService = slagalicaService;
    }

    @PostMapping("/word")
    public ResponseEntity<Word> createWord(@RequestBody Word word) {
        Word savedWord = slagalicaService.saveWord(word);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedWord);
    }

    @PostMapping("/letter")
    public ResponseEntity<Letter> createLetter(@RequestBody Letter letter) {
        // Proveri da li svi `Word` entiteti u `letter` postoje
        for (Word word : letter.getWords()) {
            if (slagalicaService.getWordById(word.getId()) == null) {
                return ResponseEntity.badRequest().body(null); // Ili baci izuzetak
            }
        }
        Letter savedLetter = slagalicaService.saveLetter(letter);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLetter);
    }
}
