package com.example.demo.hexagonal_architecture.core.service;

import com.example.demo.hexagonal_architecture.core.enitity.QuizMyNumberEntity;
import com.example.demo.hexagonal_architecture.core.port.out.in.QuizMyNumberService;
import com.example.demo.hexagonal_architecture.adapter.mapperDto.QuizMyNumberDtoMapper;
import com.example.demo.hexagonal_architecture.adapter.mapper.QuizMyNumberMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.QuizMyNumberDTO;
import com.example.demo.hexagonal_architecture.core.port.out.QuizMyNumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizMyNumberServiceImpl implements QuizMyNumberService {

    private final QuizMyNumberRepository quizMyNumberRepository;
    private final int[] NUMBER_5_BIG_NUMBER = {5, 15, 10, 20};
    private final int[] NUMBER_6_BIG_NUMBER = {25, 50, 75, 100};
    private final ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
    private final QuizMyNumberMapper quizMyNumberMapper;
    private final QuizMyNumberDtoMapper quizMyNumberDtoMapper;


    @Override
    public QuizMyNumberDTO createQuizWithRandomNumbers() {
        QuizMyNumberDTO quizDTO = generateQuizDTOWithRandomNumbers();
        QuizMyNumberEntity quizEntity = quizMyNumberMapper.apply(quizDTO);
        quizEntity = quizMyNumberRepository.createQuizWithRandomNumbers(quizEntity);
        return quizMyNumberDtoMapper.apply(quizEntity);
    }

    @Override
    public List<QuizMyNumberDTO> getAllQuiz() {
        List<QuizMyNumberEntity> quizEntityList = quizMyNumberRepository.getAllQuiz();
        return quizEntityList.stream()
                .map(quizMyNumberDtoMapper::apply)
                .collect(Collectors.toList());
    }

    private QuizMyNumberDTO generateQuizDTOWithRandomNumbers() {
        QuizMyNumberDTO quizDTO = new QuizMyNumberDTO();
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