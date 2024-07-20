
package com.example.demo.hexagonal_architecture.adapter.mapper;

import com.example.demo.hexagonal_architecture.adapter.intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.AssociationDTO;
import com.example.demo.hexagonal_architecture.core.enitity.AssociationEntity;
import org.springframework.stereotype.Component;

@Component
public class AssociationMapper implements DtoMapper<AssociationEntity, AssociationDTO> {
    @Override
    public AssociationEntity apply(AssociationDTO associationDto) {
        AssociationEntity associationEntity = new AssociationEntity();
        associationEntity.setId(associationDto.getId());
        associationEntity.setColumnA(associationDto.getColumnA());
        associationEntity.setColumnB(associationDto.getColumnB());
        associationEntity.setColumnC(associationDto.getColumnC());
        associationEntity.setColumnD(associationDto.getColumnD());
        associationEntity.setSolutions(associationDto.getSolutions());
        associationEntity.setFinalSolutions(associationDto.getFinallSolutions());
        return associationEntity;
    }
}
