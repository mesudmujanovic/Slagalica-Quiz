package com.example.demo.Service;

import com.example.demo.infrastucture.dto.QuizMyNumberDTO;

import java.util.List;

public interface QuizMyNumberService {
  public QuizMyNumberDTO createQuizWithRandomNumbers();

  public List<QuizMyNumberDTO> getAllQuiz();

}

