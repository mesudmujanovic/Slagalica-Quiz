package com.example.demo.hexagonal_architecture.adapter.mapperDto;
import com.example.demo.hexagonal_architecture.adapter.dto.FieldDTO;
import com.example.demo.hexagonal_architecture.adapter.intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.AssociationDTO;
import com.example.demo.hexagonal_architecture.core.enitity.AssociationEntity;
import com.example.demo.hexagonal_architecture.core.enitity.Field;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AssociationDtoMapper implements DtoMapper<AssociationDTO, AssociationEntity> {

    @Override
    public AssociationDTO apply(AssociationEntity associationEntity) {
        AssociationDTO associationDto = new AssociationDTO();
        associationDto.setId(associationEntity.getId());
        associationDto.setFields(
                associationEntity.getFields().stream().map(this::mapToFieldDTO).collect(Collectors.toList())
        );
        associationDto.setFinalSolutions(associationEntity.getFinalSolutions());
        associationDto.setSolutions(associationEntity.getSolutions());
        return associationDto;
    }

    private FieldDTO mapToFieldDTO(Field fieldEntity) {
        FieldDTO fieldDTO = new FieldDTO();
        fieldDTO.setText(fieldEntity.getText());
        if (fieldEntity.getPosition() != null) {
            fieldDTO.setPosition(fieldEntity.getPosition().name());
        } else {
            fieldDTO.setPosition(null);
        }
        return fieldDTO;
    }
}