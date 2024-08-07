package com.example.demo.hexagonal_architecture.adapter.mapper;

import com.example.demo.hexagonal_architecture.adapter.dto.LetterWordDTO;
import com.example.demo.hexagonal_architecture.adapter.intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.core.enitity.LetterWordEntity;
import org.springframework.stereotype.Component;

@Component
public class LetterWordMapper implements DtoMapper<LetterWordEntity, LetterWordDTO> {

    @Override
    public LetterWordEntity apply(LetterWordDTO letterWordDTO) {
        LetterWordEntity letterWordEntity = new LetterWordEntity();
        letterWordEntity.setId(letterWordDTO.getId());
        letterWordEntity.setWords(letterWordDTO.getWords());
        letterWordEntity.setLetters(letterWordDTO.getLetters());
        return letterWordEntity;
    }
}
