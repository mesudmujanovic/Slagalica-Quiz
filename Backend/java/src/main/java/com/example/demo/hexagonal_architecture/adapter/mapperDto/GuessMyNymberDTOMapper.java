package com.example.demo.hexagonal_architecture.adapter.mapperDto;

import com.example.demo.hexagonal_architecture.adapter.intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.GuessMyNymberDTO;
import com.example.demo.hexagonal_architecture.core.enitity.GuessMyNymberEntity;
import org.springframework.stereotype.Component;

@Component
public class GuessMyNymberDTOMapper implements DtoMapper<GuessMyNymberDTO, GuessMyNymberEntity> {

    @Override
    public GuessMyNymberDTO apply(GuessMyNymberEntity quizEntity) {
        GuessMyNymberDTO quizDTO = new GuessMyNymberDTO();
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