package com.example.demo.Controller;

import com.example.demo.Service.Impl.QuizMyNumberServiceImpl;
import com.example.demo.infrastucture.Request.QuizMyNumberRequest;
import com.example.demo.infrastucture.Response.QuizMyNumberResponse;
import com.example.demo.infrastucture.dto.QuizMyNumberDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizMyNumberController {

    private final QuizMyNumberServiceImpl quizService;

    public QuizMyNumberController(QuizMyNumberServiceImpl quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/create")
    public ResponseEntity<QuizMyNumberResponse> createQuizWithRandomNumbers(@RequestBody QuizMyNumberRequest quizRequest) {
        QuizMyNumberDTO quizDTO = QuizMyNumberDTO.fromRequestToDto(quizRequest);
        QuizMyNumberDTO saveQuizDTO = quizService.createQuizWithRandomNumbers();
        return ResponseEntity.ok(saveQuizDTO.fromDtoToResponse());
    }

    @GetMapping("getAllQuiz")
    public ResponseEntity<List<QuizMyNumberResponse>> getAllQuiz(){
        List<QuizMyNumberDTO> quizDTOS = quizService.getAllQuiz();
        return ResponseEntity.ok(quizDTOS.stream().map(QuizMyNumberDTO::fromDtoToResponse).collect(Collectors.toList()));
    }
}
