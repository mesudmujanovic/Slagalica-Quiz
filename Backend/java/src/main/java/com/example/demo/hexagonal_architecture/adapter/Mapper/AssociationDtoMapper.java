package com.example.demo.hexagonal_architecture.adapter.Mapper;
import com.example.demo.hexagonal_architecture.adapter.Intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.AssociationDto;
import com.example.demo.hexagonal_architecture.core.Enitity.AssociationEntity;
import org.springframework.stereotype.Component;

@Component
public class AssociationDtoMapper implements DtoMapper<AssociationDto, AssociationEntity> {

    @Override
    public AssociationDto apply(AssociationEntity associationEntity) {
        AssociationDto associationDto = new AssociationDto();
        associationDto.setId(associationEntity.getId());
        associationDto.setColumnA(associationEntity.getColumnA());
        associationDto.setColumnB(associationEntity.getColumnB());
        associationDto.setColumnC(associationEntity.getColumnC());
        associationDto.setColumnD(associationEntity.getColumnD());
        associationDto.setSolutions(associationEntity.getSolutions());
        associationDto.setFinallSolutions(associationEntity.getFinalSolutions());
        return associationDto;
    }
}