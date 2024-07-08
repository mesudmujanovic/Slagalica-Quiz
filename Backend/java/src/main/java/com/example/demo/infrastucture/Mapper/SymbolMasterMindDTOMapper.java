package com.example.demo.infrastucture.Mapper;

import com.example.demo.Enitity.SymbolMastermind;
import com.example.demo.Intergration.DtoMapper;
import com.example.demo.infrastucture.dto.SymbolMastermindDTO;

public enum SymbolMasterMindDTOMapper implements DtoMapper<SymbolMastermindDTO, SymbolMastermind> {
    INSTANCE;


    @Override
    public SymbolMastermindDTO apply(SymbolMastermind symbolMastermind) {
        SymbolMastermindDTO symbolMastermindDTO = new SymbolMastermindDTO();
        symbolMastermindDTO.setId(symbolMastermindDTO.getId());
        symbolMastermindDTO.setName(symbolMastermindDTO.getName());
        symbolMastermindDTO.setImage(symbolMastermindDTO.getImage());
        return null;
    }
}
