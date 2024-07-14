
package com.example.demo.hexagonal_architecture.adapter.Mapper;

import com.example.demo.hexagonal_architecture.adapter.Intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.AssociationDto;
import com.example.demo.hexagonal_architecture.core.Enitity.AssociationEntity;
import org.springframework.stereotype.Component;

@Component
public class AssociationMapper implements DtoMapper<AssociationEntity, AssociationDto> {

    @Override
    public AssociationEntity apply(AssociationDto associationDto) {
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
