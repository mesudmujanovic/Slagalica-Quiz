package com.example.demo.Service.Impl;

import com.example.demo.Enitity.QuizMyNumberEntity;
import com.example.demo.Repo.QuizMyNumberRepo;
import com.example.demo.Service.QuizMyNumberService;
import com.example.demo.infrastucture.Mapper.QuizMyNumberDtoMapper;
import com.example.demo.infrastucture.Mapper.QuizMyNumberMapper;
import com.example.demo.infrastucture.dto.QuizMyNumberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class QuizMyNumberServiceImpl implements QuizMyNumberService {

    private final QuizMyNumberRepo quizRepository;
    private final int[] NUMBER_5_OPTIONS = {5, 15, 10, 20};
    private final int[] NUMBER_6_OPTIONS = {25, 50, 75, 100};
    private final ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

    @Autowired
    public QuizMyNumberServiceImpl(QuizMyNumberRepo quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public QuizMyNumberDTO createQuizWithRandomNumbers() {
        QuizMyNumberDTO quizDTO = generateQuizDTOWithRandomNumbers();
        QuizMyNumberEntity quizEntity = QuizMyNumberMapper.INSTANCE.apply(quizDTO);
        quizEntity = quizRepository.save(quizEntity);
        return QuizMyNumberDtoMapper.INSTANCE.apply(quizEntity);
    }

    @Override
    public List<QuizMyNumberDTO> getAllQuiz() {
        List<QuizMyNumberEntity> quizEntityList = quizRepository.findAll();
        return quizEntityList.stream()
                .map(QuizMyNumberDtoMapper.INSTANCE::apply)
                .collect(Collectors.toList());
    }

    private QuizMyNumberDTO generateQuizDTOWithRandomNumbers() {
        QuizMyNumberDTO quizDTO = new QuizMyNumberDTO();
        quizDTO.setNumber1(generateRandomNumberBetween(1, 9));
        quizDTO.setNumber2(generateRandomNumberBetween(1, 9));
        quizDTO.setNumber3(generateRandomNumberBetween(1, 9));
        quizDTO.setNumber4(generateRandomNumberBetween(1, 9));
        quizDTO.setNumber5(generateRandomNumberFromArray(NUMBER_5_OPTIONS));
        quizDTO.setNumber6(generateRandomNumberFromArray(NUMBER_6_OPTIONS));
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
