package com.example.demo.hexagonal_architecture.adapter.out.repository;

import com.example.demo.hexagonal_architecture.core.enitity.GuessMyNymberEntity;
import com.example.demo.hexagonal_architecture.core.port.out.GuessMyNymberRepository;
import com.example.demo.hexagonal_architecture.core.port.out.persistence.JpaGuessMyNymber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GuessMyNymberRepositoryImpl implements GuessMyNymberRepository {

    private final JpaGuessMyNymber jpaGuessMyNymber;
    @Override
    public GuessMyNymberEntity createQuizWithRandomNumbers(GuessMyNymberEntity guessMyNymberEntity) {
        return jpaGuessMyNymber.save(guessMyNymberEntity);
    }
    @Override
    public List<GuessMyNymberEntity> getAllQuiz() {
        return jpaGuessMyNymber.findAll();
    }
}
