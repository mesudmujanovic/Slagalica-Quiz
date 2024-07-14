package com.example.demo.hexagonal_architecture.core.port.out;

import com.example.demo.hexagonal_architecture.core.Enitity.QuizMyNumberEntity;

import java.util.List;

public interface QuizMyNumberRepository {
    public QuizMyNumberEntity createQuizWithRandomNumbers(QuizMyNumberEntity quizMyNumberEntity);
    public List<QuizMyNumberEntity> getAllQuiz();
}
