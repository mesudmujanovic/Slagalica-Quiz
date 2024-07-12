package com.example.demo.infrastucture.Mapper;

import com.example.demo.Enitity.SymbolMastermind;
import com.example.demo.Intergration.DtoMapper;
import com.example.demo.infrastucture.dto.SymbolMastermindDTO;
import org.springframework.stereotype.Component;

@Component
public class SymbolMasterMindDTOMapper implements DtoMapper<SymbolMastermindDTO, SymbolMastermind> {

    @Override
    public SymbolMastermindDTO apply(SymbolMastermind symbolMastermind) {
        SymbolMastermindDTO symbolMastermindDTO = new SymbolMastermindDTO();
        symbolMastermindDTO.setId(symbolMastermind.getId());
        symbolMastermindDTO.setName(symbolMastermind.getName());
        symbolMastermindDTO.setImage(symbolMastermind.getImage());
        return symbolMastermindDTO;
    }
}