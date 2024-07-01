package com.example.demo.Service.Impl;

import com.example.demo.Enitity.QuizMyNumberEntity;
import com.example.demo.Repo.QuizMyNumberRepo;
import com.example.demo.Service.QuizMyNumberService;
import com.example.demo.infrastucture.Mapper.QuizMyNumberDtoMapper;
import com.example.demo.infrastucture.Mapper.QuizMyNumberMapper;
import com.example.demo.infrastucture.dto.QuizMyNumberDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuizMyNumberServiceImpl implements QuizMyNumberService {
    private final QuizMyNumberRepo quizRepository;


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

    private QuizMyNumberDTO generateQuizDTOWithRandomNumbers() {
        Random random = new Random();
        QuizMyNumberDTO quizDTO = new QuizMyNumberDTO();
        quizDTO.setNumber1(random.nextInt(9) + 1);
        quizDTO.setNumber2(random.nextInt(9) + 1);
        quizDTO.setNumber3(random.nextInt(9) + 1);
        quizDTO.setNumber4(random.nextInt(9) + 1);
        quizDTO.setNumber5(generateRandomNumber5());
        quizDTO.setNumber6(generateRandomNumber6());
        quizDTO.setResult(generateRandomResult());
        return quizDTO;
    }

    private int generateRandomResult(){
        Random random = new Random();
        return random.nextInt(900)+100;
    }

    private int generateRandomNumber5(){
        int[] number = {5,15,10,20};
        Random random = new Random();
        int index = random.nextInt(number.length);
        return number[index];
    }

    private int generateRandomNumber6(){
        int[] number = {25,50,75,100};
        Random random = new Random();
        int index = random.nextInt(number.length);
        return  number[index];
    }

    @Override
    public List<QuizMyNumberDTO> getAllQuiz() {
        List<QuizMyNumberEntity> quizEntityList = quizRepository.findAll();
        return quizEntityList.stream().map(QuizMyNumberDtoMapper.INSTANCE::apply).collect(Collectors.toList());
    }
}
