package com.example.demo.hexagonal_architecture.adapter.in.web.Controller;

import com.example.demo.hexagonal_architecture.adapter.Request.QuizMyNumberRequest;
import com.example.demo.hexagonal_architecture.adapter.Response.QuizMyNumberResponse;
import com.example.demo.hexagonal_architecture.adapter.dto.QuizMyNumberDTO;
import com.example.demo.hexagonal_architecture.core.port.in.QuizMyNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
@RequiredArgsConstructor
public class QuizMyNumberController {
    private final QuizMyNumberService quizMyNumberService;

    @PostMapping("/create")
    public ResponseEntity<QuizMyNumberResponse> createQuizWithRandomNumbers(@RequestBody QuizMyNumberRequest quizRequest) {
        QuizMyNumberDTO quizDTO = QuizMyNumberDTO.fromRequestToDto(quizRequest);
        QuizMyNumberDTO saveQuizDTO = quizMyNumberService.createQuizWithRandomNumbers();
        return ResponseEntity.ok(saveQuizDTO.fromDtoToResponse());
    }

    @GetMapping("getAllQuiz")
    public ResponseEntity<List<QuizMyNumberResponse>> getAllQuiz(){
        List<QuizMyNumberDTO> quizDTOS = quizMyNumberService.getAllQuiz();
        return ResponseEntity.ok(quizDTOS.stream().map(QuizMyNumberDTO::fromDtoToResponse).collect(Collectors.toList()));
    }
}