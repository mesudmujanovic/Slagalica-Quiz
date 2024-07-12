package com.example.demo.infrastucture.Mapper;

import com.example.demo.Enitity.QuizMyNumberEntity;
import com.example.demo.Intergration.DtoMapper;
import com.example.demo.infrastucture.dto.QuizMyNumberDTO;
import org.springframework.stereotype.Component;

@Component
public class QuizMyNumberMapper implements DtoMapper<QuizMyNumberEntity, QuizMyNumberDTO> {

    @Override
    public QuizMyNumberEntity apply(QuizMyNumberDTO quizDto) {
        QuizMyNumberEntity quizEntity = new QuizMyNumberEntity();
        quizEntity.setId(quizDto.getId());
        quizEntity.setNumber1(quizDto.getNumber1());
        quizEntity.setNumber2(quizDto.getNumber2());
        quizEntity.setNumber3(quizDto.getNumber3());
        quizEntity.setNumber4(quizDto.getNumber4());
        quizEntity.setNumber5(quizDto.getNumber5());
        quizEntity.setNumber6(quizDto.getNumber6());
        quizEntity.setResult(quizDto.getResult());
        return quizEntity;
    }
}