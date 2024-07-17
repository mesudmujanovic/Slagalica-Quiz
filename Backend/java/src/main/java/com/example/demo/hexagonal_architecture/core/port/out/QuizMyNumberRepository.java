package com.example.demo.hexagonal_architecture.core.port.out;

import com.example.demo.hexagonal_architecture.core.enitity.QuizMyNumberEntity;

import java.util.List;

public interface QuizMyNumberRepository {
    public QuizMyNumberEntity createQuizWithRandomNumbers(QuizMyNumberEntity quizMyNumberEntity);
    public List<QuizMyNumberEntity> getAllQuiz();
}
