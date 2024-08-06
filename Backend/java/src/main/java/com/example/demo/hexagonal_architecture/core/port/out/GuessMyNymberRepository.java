package com.example.demo.hexagonal_architecture.core.port.out;

import com.example.demo.hexagonal_architecture.core.enitity.GuessMyNymberEntity;
import java.util.List;

public interface GuessMyNymberRepository {
     GuessMyNymberEntity createQuizWithRandomNumbers(GuessMyNymberEntity guessMyNymberEntity);
     List<GuessMyNymberEntity> getAllQuiz();
}
