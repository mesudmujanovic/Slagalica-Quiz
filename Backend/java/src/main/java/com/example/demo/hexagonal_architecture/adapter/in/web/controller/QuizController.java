package com.example.demo.hexagonal_architecture.adapter.in.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/two-players")
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;
    @PostMapping("/players/{player1Id}/{player2Id}")
    public ResponseEntity<QuizEntity> createQuiz(@PathVariable Long player1Id,
                                                 @PathVariable Long player2Id) {
        QuizEntity quiz = quizService.createQuiz(player1Id, player2Id);
        return ResponseEntity.ok(quiz);
    }
}
