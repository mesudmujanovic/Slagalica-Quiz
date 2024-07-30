package com.example.demo.hexagonal_architecture.adapter.mockdata;

import com.example.demo.hexagonal_architecture.adapter.dto.QuizMyNumberDTO;
import com.example.demo.hexagonal_architecture.core.port.out.in.QuizMyNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MyNumberAssoc implements CommandLineRunner {
    private final QuizMyNumberService quizMyNumberService;

    @Override
    public void run(String... args) throws Exception {
        try {
            List<QuizMyNumberDTO> quizMyNumberDTOS = fetchQuizMyNumberEntities();

            if (!quizMyNumberDTOS.isEmpty()) {
                quizMyNumberDTOS.forEach(dto -> quizMyNumberService.createQuizWithRandomNumbers());
            } else {
                System.out.println("No MY NUMBER loaded from mock data.");
            }
        } catch (Exception e) {
            System.err.println("Error occurred while processing mock data: " + e.getMessage());
        }
    }
    private List<QuizMyNumberDTO> fetchQuizMyNumberEntities() {
        return List.of(
                new QuizMyNumberDTO(),
                new QuizMyNumberDTO(),
                new QuizMyNumberDTO()
        );
    }
}
