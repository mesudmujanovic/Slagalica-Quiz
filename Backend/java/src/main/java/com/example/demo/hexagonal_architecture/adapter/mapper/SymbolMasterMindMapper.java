package com.example.demo.hexagonal_architecture.adapter.mapper;

import com.example.demo.hexagonal_architecture.adapter.intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.SymbolMastermindDTO;
import com.example.demo.hexagonal_architecture.core.enitity.SymbolMastermindEntity;
import org.springframework.stereotype.Component;

@Component
public class SymbolMasterMindMapper implements DtoMapper<SymbolMastermindEntity, SymbolMastermindDTO> {

    @Override
    public SymbolMastermindEntity apply(SymbolMastermindDTO symbolMastermindDTO) {
        SymbolMastermindEntity symbolMastermindEntity = new SymbolMastermindEntity();
        symbolMastermindEntity.setId(symbolMastermindDTO.getId());
        symbolMastermindEntity.setName(symbolMastermindDTO.getName());
        symbolMastermindEntity.setImage(symbolMastermindDTO.getImage());
        return symbolMastermindEntity;
    }
}