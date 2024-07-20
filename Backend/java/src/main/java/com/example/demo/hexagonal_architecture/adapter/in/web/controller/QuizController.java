package com.example.demo.hexagonal_architecture.adapter.in.web.controller;

import com.example.demo.hexagonal_architecture.core.enitity.QuizEntity;
import com.example.demo.hexagonal_architecture.core.service.QuizService;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/create/{player1Id}/{player2Id}")
    public ResponseEntity<QuizEntity> createQuiz(
            @PathVariable Long player1Id,
            @PathVariable Long player2Id) {
        QuizEntity quiz = quizService.createQuiz(player1Id, player2Id);
        return ResponseEntity.ok(quiz);
    }

}
