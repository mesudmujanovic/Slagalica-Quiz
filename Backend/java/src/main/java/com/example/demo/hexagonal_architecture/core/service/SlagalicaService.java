package com.example.demo.hexagonal_architecture.core.service;

import com.example.demo.hexagonal_architecture.core.enitity.guessTheWordsEntity.Letter;
import com.example.demo.hexagonal_architecture.core.enitity.guessTheWordsEntity.Word;
import com.example.demo.hexagonal_architecture.core.port.out.persistence.guessTheWordsEntity.JpaLetter;
import com.example.demo.hexagonal_architecture.core.port.out.persistence.guessTheWordsEntity.JpaWord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SlagalicaService {

    private final JpaLetter letterRepository;
    private final JpaWord wordRepository;


    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    public Optional<Word> getWordById(Long id) {
        return wordRepository.findById(id);
    }

    public Word saveWord(Word word) {
        return wordRepository.save(word);
    }

    public void deleteWord(Long id) {
        wordRepository.deleteById(id);
    }

    public List<Letter> getAllLetters() {
        return letterRepository.findAll();
    }

    public Optional<Letter> getLetterById(Long id) {
        return letterRepository.findById(id);
    }

    public Letter saveLetter(Letter letter) {
        return letterRepository.save(letter);
    }

    public void deleteLetter(Long id) {
        letterRepository.deleteById(id);
    }
}
