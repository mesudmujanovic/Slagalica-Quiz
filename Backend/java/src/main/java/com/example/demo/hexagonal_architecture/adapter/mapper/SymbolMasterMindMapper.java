package com.example.demo.hexagonal_architecture.adapter.mapper;

import com.example.demo.hexagonal_architecture.adapter.intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.SymbolMastermindDTO;
import com.example.demo.hexagonal_architecture.core.enitity.SymbolMastermind;
import org.springframework.stereotype.Component;

@Component
public class SymbolMasterMindMapper implements DtoMapper<SymbolMastermind, SymbolMastermindDTO> {
    @Override
    public SymbolMastermind apply(SymbolMastermindDTO symbolMastermindDTO) {
        SymbolMastermind symbolMastermind = new SymbolMastermind();
        symbolMastermind.setId(symbolMastermindDTO.getId());
        symbolMastermind.setName(symbolMastermindDTO.getName());
        symbolMastermind.setImage(symbolMastermindDTO.getImage());
        return symbolMastermind;
    }
}