package com.example.demo.hexagonal_architecture.core.port.out.in;

import com.example.demo.hexagonal_architecture.adapter.dto.GuessMyNymberDTO;

import java.util.List;

public interface GuessMyNymberService {
     GuessMyNymberDTO createQuizWithRandomNumbers();
     List<GuessMyNymberDTO> getAllQuiz();
}

