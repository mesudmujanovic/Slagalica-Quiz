package com.example.demo.infrastucture.Mapper;

import com.example.demo.Enitity.QuizMyNumberEntity;
import com.example.demo.Intergration.DtoMapper;
import com.example.demo.infrastucture.dto.QuizMyNumberDTO;
import org.springframework.stereotype.Component;

@Component
public class QuizMyNumberDtoMapper implements DtoMapper<QuizMyNumberDTO, QuizMyNumberEntity> {

    @Override
    public QuizMyNumberDTO apply(QuizMyNumberEntity quizEntity) {
        QuizMyNumberDTO quizDTO = new QuizMyNumberDTO();
        quizDTO.setId(quizEntity.getId());
        quizDTO.setNumber4(quizEntity.getNumber4());
        quizDTO.setNumber3(quizEntity.getNumber3());
        quizDTO.setNumber2(quizEntity.getNumber2());
        quizDTO.setNumber1(quizEntity.getNumber1());
        quizDTO.setNumber5(quizEntity.getNumber5());
        quizDTO.setNumber6(quizEntity.getNumber6());
        quizDTO.setResult(quizEntity.getResult());
        return quizDTO;
    }
}