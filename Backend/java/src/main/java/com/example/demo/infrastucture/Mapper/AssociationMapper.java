package com.example.demo.infrastucture.Mapper;

import com.example.demo.Enitity.AssociationEntity;
import com.example.demo.Intergration.DtoMapper;
import com.example.demo.infrastucture.dto.AssociationDto;

public enum AssociationMapper implements DtoMapper<AssociationEntity, AssociationDto> {
    INSTANCE;

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
