package com.example.demo.hexagonal_architecture.core.service;

import com.example.demo.hexagonal_architecture.adapter.mapper.GuessMyNymberMapper;
import com.example.demo.hexagonal_architecture.core.enitity.GuessMyNymberEntity;
import com.example.demo.hexagonal_architecture.core.port.out.in.GuessMyNymberService;
import com.example.demo.hexagonal_architecture.adapter.mapperDto.GuessMyNymberDTOMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.GuessMyNymberDTO;
import com.example.demo.hexagonal_architecture.core.port.out.GuessMyNymberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuessMyNymberServiceImpl implements GuessMyNymberService {

    private final GuessMyNymberRepository guessMyNymberRepository;
    private final int[] NUMBER_5_BIG_NUMBER = {5, 15, 10, 20};
    private final int[] NUMBER_6_BIG_NUMBER = {25, 50, 75, 100};
    private final ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
    private final GuessMyNymberMapper guessMyNymberMapper;
    private final GuessMyNymberDTOMapper guessMyNymberDTOMapper;



    @Override
    public GuessMyNymberDTO createQuizWithRandomNumbers() {
        GuessMyNymberDTO quizDTO = generateQuizDTOWithRandomNumbers();
        GuessMyNymberEntity quizEntity = guessMyNymberMapper.apply(quizDTO);
        quizEntity = guessMyNymberRepository.createQuizWithRandomNumbers(quizEntity);
        return guessMyNymberDTOMapper.apply(quizEntity);
    }

    @Override
    public List<GuessMyNymberDTO> getAllQuiz() {
        List<GuessMyNymberEntity> quizEntityList = guessMyNymberRepository.getAllQuiz();
        return quizEntityList.stream()
                .map(guessMyNymberDTOMapper::apply)
                .collect(Collectors.toList());
    }

    private GuessMyNymberDTO generateQuizDTOWithRandomNumbers() {
        GuessMyNymberDTO quizDTO = new GuessMyNymberDTO();
        quizDTO.setNumber1(generateRandomNumberBetween(1, 9));
        quizDTO.setNumber2(generateRandomNumberBetween(1, 9));
        quizDTO.setNumber3(generateRandomNumberBetween(1, 9));
        quizDTO.setNumber4(generateRandomNumberBetween(1, 9));
        quizDTO.setNumber5(generateRandomNumberFromArray(NUMBER_5_BIG_NUMBER));
        quizDTO.setNumber6(generateRandomNumberFromArray(NUMBER_6_BIG_NUMBER));
        quizDTO.setResult(generateRandomResult());
        return quizDTO;
    }

    private int generateRandomNumberBetween(int min, int max) {
        return threadLocalRandom.nextInt(min, max + 1);
    }

    private int generateRandomNumberFromArray(int[] numbers) {
        return numbers[threadLocalRandom.nextInt(numbers.length)];
    }
    private int generateRandomResult() {
        return threadLocalRandom.nextInt(100, 901);
    }
}