package com.example.demo.hexagonal_architecture.core.service;

import com.example.demo.hexagonal_architecture.core.enitity.PlayerEntity;
import com.example.demo.hexagonal_architecture.core.enitity.QuizEntity;
import com.example.demo.hexagonal_architecture.core.port.out.PlayerRepository;
import com.example.demo.hexagonal_architecture.core.port.out.persistence.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;
    private final PlayerRepository playerRepository;

    public QuizEntity createQuiz(Long player1Id, Long player2Id) {
        PlayerEntity player1 = playerRepository.findById(player1Id);
        PlayerEntity player2 = playerRepository.findById(player2Id);
        QuizEntity quiz = QuizEntity.builder()
                .player1(player1)
                .player2(player2)
                .startTime(LocalDateTime.now())
                .build();

        return quizRepository.save(quiz);
    }
}