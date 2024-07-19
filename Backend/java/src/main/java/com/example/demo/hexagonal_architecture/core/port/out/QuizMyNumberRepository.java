package com.example.demo.hexagonal_architecture.core.port.out;

import com.example.demo.hexagonal_architecture.core.enitity.QuizMyNumberEntity;
import java.util.List;

public interface QuizMyNumberRepository {
     QuizMyNumberEntity createQuizWithRandomNumbers(QuizMyNumberEntity quizMyNumberEntity);
     List<QuizMyNumberEntity> getAllQuiz();
}
