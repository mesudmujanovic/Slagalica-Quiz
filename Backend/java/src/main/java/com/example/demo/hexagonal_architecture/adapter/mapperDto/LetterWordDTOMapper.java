package com.example.demo.hexagonal_architecture.adapter.mapperDto;

import com.example.demo.hexagonal_architecture.adapter.dto.LetterWordDTO;
import com.example.demo.hexagonal_architecture.adapter.intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.core.enitity.LetterWordEntity;
import org.springframework.stereotype.Component;

@Component
public class LetterWordDTOMapper implements DtoMapper<LetterWordDTO, LetterWordEntity> {

    @Override
    public LetterWordDTO apply(LetterWordEntity letterWordEntity) {
        LetterWordDTO letterWordDTO = new LetterWordDTO();
        letterWordDTO.setId(letterWordEntity.getId());
        letterWordDTO.setWords(letterWordEntity.getWords());
        letterWordDTO.setLetters(letterWordEntity.getLetters());
        return letterWordDTO;
    }
}
