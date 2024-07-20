package com.example.demo.hexagonal_architecture.adapter.mapper;

import com.example.demo.hexagonal_architecture.adapter.intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.QuizMyNumberDTO;
import com.example.demo.hexagonal_architecture.core.enitity.QuizMyNumberEntity;
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