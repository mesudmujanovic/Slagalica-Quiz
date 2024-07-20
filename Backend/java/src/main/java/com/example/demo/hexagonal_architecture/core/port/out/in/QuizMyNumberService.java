package com.example.demo.hexagonal_architecture.core.port.out.in;

import com.example.demo.hexagonal_architecture.adapter.dto.QuizMyNumberDTO;

import java.util.List;

public interface QuizMyNumberService {
     QuizMyNumberDTO createQuizWithRandomNumbers();
     List<QuizMyNumberDTO> getAllQuiz();
}

