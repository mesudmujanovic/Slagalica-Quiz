package com.example.demo.hexagonal_architecture.core.port.in;

import com.example.demo.hexagonal_architecture.adapter.dto.QuizMyNumberDTO;

import java.util.List;

public interface QuizMyNumberService {
  public QuizMyNumberDTO createQuizWithRandomNumbers();
  public List<QuizMyNumberDTO> getAllQuiz();
}

