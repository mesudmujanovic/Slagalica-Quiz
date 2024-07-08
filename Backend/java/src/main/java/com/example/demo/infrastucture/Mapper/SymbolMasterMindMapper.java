package com.example.demo.infrastucture.Mapper;

import com.example.demo.Intergration.DtoMapper;
import com.example.demo.infrastucture.dto.SymbolMastermindDTO;
import com.example.demo.Enitity.SymbolMastermind;

public enum SymbolMasterMindMapper implements DtoMapper<SymbolMastermind, SymbolMastermindDTO> {
    INSTANCE;

    @Override
    public SymbolMastermind apply(SymbolMastermindDTO symbolMastermindDTO) {
        SymbolMastermind symbolMastermind = new SymbolMastermind();
        symbolMastermind.setId(symbolMastermindDTO.getId());
        symbolMastermind.setName(symbolMastermindDTO.getName());
        symbolMastermind.setImage(symbolMastermindDTO.getImage());
        return symbolMastermind;
    }
}
