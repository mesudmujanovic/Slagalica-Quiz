package com.example.demo.hexagonal_architecture.adapter.out.repository;

import com.example.demo.hexagonal_architecture.core.enitity.GuessMyNymberEntity;
import com.example.demo.hexagonal_architecture.core.port.out.GuessMyNymberRepository;
import com.example.demo.hexagonal_architecture.core.port.out.persistenceJpa.GuessMyNymberJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GuessMyNymberRepositoryImpl implements GuessMyNymberRepository {

    private final GuessMyNymberJpa guessMyNymberJpa;
    @Override
    public GuessMyNymberEntity createQuizWithRandomNumbers(GuessMyNymberEntity guessMyNymberEntity) {
        return guessMyNymberJpa.save(guessMyNymberEntity);
    }
    @Override
    public List<GuessMyNymberEntity> getAllQuiz() {
        return guessMyNymberJpa.findAll();
    }
}
