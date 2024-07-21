package com.example.demo.hexagonal_architecture.adapter.in.web.controller;

import com.example.demo.hexagonal_architecture.adapter.request.QuizMyNumberRequest;
import com.example.demo.hexagonal_architecture.adapter.response.QuizMyNumberResponse;
import com.example.demo.hexagonal_architecture.adapter.dto.QuizMyNumberDTO;
import com.example.demo.hexagonal_architecture.core.port.out.in.QuizMyNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/number-game")
@RequiredArgsConstructor
public class QuizMyNumberController {
    private final QuizMyNumberService quizMyNumberService;

    @PostMapping("/my-number")
    public ResponseEntity<QuizMyNumberResponse> createQuizWithRandomNumbers(@RequestBody QuizMyNumberRequest quizRequest) {
        QuizMyNumberDTO quizDTO = QuizMyNumberDTO.fromRequestToDto(quizRequest);
        QuizMyNumberResponse quizMyNumberResponse = quizMyNumberService.createQuizWithRandomNumbers().fromDtoToResponse();
        return ResponseEntity.ok(quizMyNumberResponse);
    }

    @GetMapping("/my-numbers")
    public ResponseEntity<List<QuizMyNumberResponse>> getAllQuiz(){
        List<QuizMyNumberDTO> quizDTOS = quizMyNumberService.getAllQuiz();
        List<QuizMyNumberResponse> quizMyNumberResponses = quizDTOS
            .stream()
            .map(QuizMyNumberDTO::fromDtoToResponse)
            .collect(Collectors.toList());
        return ResponseEntity.ok(quizMyNumberResponses);
    }
}