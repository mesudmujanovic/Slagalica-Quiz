package com.example.demo.hexagonal_architecture.adapter.in.web.controller;

import com.example.demo.hexagonal_architecture.adapter.request.GuessMyNymberRequest;
import com.example.demo.hexagonal_architecture.adapter.response.GuessMyNymberResponse;
import com.example.demo.hexagonal_architecture.adapter.dto.GuessMyNymberDTO;
import com.example.demo.hexagonal_architecture.core.port.out.in.GuessMyNymberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/number-game")
@RequiredArgsConstructor
public class GuessMyNymberController {
    private final GuessMyNymberService guessMyNymberService;

    @PostMapping("/my-number")
    public ResponseEntity<GuessMyNymberResponse> createQuizWithRandomNumbers(@RequestBody GuessMyNymberRequest quizRequest) {
        GuessMyNymberResponse guessMyNymberResponse = guessMyNymberService.createQuizWithRandomNumbers().fromDtoToResponse();
        return ResponseEntity.ok(guessMyNymberResponse);
    }

    @GetMapping("/my-numbers")
    public ResponseEntity<List<GuessMyNymberResponse>> getAllQuiz(){
        List<GuessMyNymberDTO> quizDTOS = guessMyNymberService.getAllQuiz();
        List<GuessMyNymberResponse> guessMyNymberRespons = quizDTOS
            .stream()
            .map(GuessMyNymberDTO::fromDtoToResponse)
            .collect(Collectors.toList());
        return ResponseEntity.ok(guessMyNymberRespons);
    }
}