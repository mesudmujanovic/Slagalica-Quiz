package com.example.demo.hexagonal_architecture.adapter.mapperDto;
import com.example.demo.hexagonal_architecture.adapter.intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.AssociationDTO;
import com.example.demo.hexagonal_architecture.core.enitity.AssociationEntity;
import org.springframework.stereotype.Component;

@Component
public class AssociationDtoMapper implements DtoMapper<AssociationDTO, AssociationEntity> {

    @Override
    public AssociationDTO apply(AssociationEntity associationEntity) {
        AssociationDTO associationDto = new AssociationDTO();
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