package com.example.demo.mockdata;

import com.example.demo.hexagonal_architecture.adapter.dto.GuessMyNymberDTO;
import com.example.demo.hexagonal_architecture.core.port.out.in.GuessMyNymberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MyNumberAssoc implements CommandLineRunner {
    private final GuessMyNymberService guessMyNymberService;

    @Override
    public void run(String... args) throws Exception {
        try {
            List<GuessMyNymberDTO> guessMyNymberDTOS = fetchQuizMyNumberEntities();

            if (!guessMyNymberDTOS.isEmpty()) {
                guessMyNymberDTOS.forEach(dto -> guessMyNymberService.createQuizWithRandomNumbers());
            } else {
                System.out.println("No MY NUMBER loaded from mock data.");
            }
        } catch (Exception e) {
            System.err.println("Error occurred while processing mock data: " + e.getMessage());
        }
    }
    private List<GuessMyNymberDTO> fetchQuizMyNumberEntities() {
        return List.of(
                new GuessMyNymberDTO(),
                new GuessMyNymberDTO(),
                new GuessMyNymberDTO()
        );
    }
}
