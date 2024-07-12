package com.example.demo.infrastucture.Mapper;
import com.example.demo.Enitity.AssociationEntity;
import com.example.demo.Intergration.DtoMapper;
import com.example.demo.infrastucture.dto.AssociationDto;
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