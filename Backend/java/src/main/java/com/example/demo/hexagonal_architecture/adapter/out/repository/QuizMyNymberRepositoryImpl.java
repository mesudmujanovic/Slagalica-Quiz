package com.example.demo.hexagonal_architecture.adapter.out.repository;

import com.example.demo.hexagonal_architecture.core.enitity.QuizMyNumberEntity;
import com.example.demo.hexagonal_architecture.core.port.out.QuizMyNumberRepository;
import com.example.demo.hexagonal_architecture.core.port.out.persistence.JpaQuizMyNumber;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuizMyNymberRepositoryImpl implements QuizMyNumberRepository {

     private final JpaQuizMyNumber jpaQuizMyNumber;

    public QuizMyNymberRepositoryImpl(JpaQuizMyNumber jpaQuizMyNumber) {
        this.jpaQuizMyNumber = jpaQuizMyNumber;
    }

    @Override
    public QuizMyNumberEntity createQuizWithRandomNumbers(QuizMyNumberEntity quizMyNumberEntity) {
        return jpaQuizMyNumber.save(quizMyNumberEntity);
    }

    @Override
    public List<QuizMyNumberEntity> getAllQuiz() {
        return jpaQuizMyNumber.findAll();
    }
}
