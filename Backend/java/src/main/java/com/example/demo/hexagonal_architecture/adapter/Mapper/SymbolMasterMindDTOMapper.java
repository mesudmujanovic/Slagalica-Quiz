package com.example.demo.hexagonal_architecture.adapter.Mapper;

import com.example.demo.hexagonal_architecture.core.Enitity.SymbolMastermind;
import com.example.demo.hexagonal_architecture.adapter.Intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.SymbolMastermindDTO;
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