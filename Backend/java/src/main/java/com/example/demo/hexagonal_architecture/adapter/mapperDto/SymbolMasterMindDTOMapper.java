package com.example.demo.hexagonal_architecture.adapter.mapperDto;
import com.example.demo.hexagonal_architecture.core.enitity.SymbolMastermindEntity;
import com.example.demo.hexagonal_architecture.adapter.intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.SymbolMastermindDTO;
import org.springframework.stereotype.Component;

@Component
public class SymbolMasterMindDTOMapper implements DtoMapper<SymbolMastermindDTO, SymbolMastermindEntity> {

    @Override
    public SymbolMastermindDTO apply(SymbolMastermindEntity symbolMastermindEntity) {
        SymbolMastermindDTO symbolMastermindDTO = new SymbolMastermindDTO();
        symbolMastermindDTO.setId(symbolMastermindEntity.getId());
        symbolMastermindDTO.setName(symbolMastermindEntity.getName());
        symbolMastermindDTO.setImage(symbolMastermindEntity.getImage());
        return symbolMastermindDTO;
    }
}