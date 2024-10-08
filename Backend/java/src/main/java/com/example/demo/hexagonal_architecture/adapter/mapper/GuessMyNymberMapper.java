package com.example.demo.hexagonal_architecture.adapter.mapper;

import com.example.demo.hexagonal_architecture.adapter.intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.GuessMyNymberDTO;
import com.example.demo.hexagonal_architecture.core.enitity.GuessMyNymberEntity;
import org.springframework.stereotype.Component;

@Component
public class GuessMyNymberMapper implements DtoMapper<GuessMyNymberEntity, GuessMyNymberDTO> {

    @Override
    public GuessMyNymberEntity apply(GuessMyNymberDTO quizDto) {
        GuessMyNymberEntity quizEntity = new GuessMyNymberEntity();
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