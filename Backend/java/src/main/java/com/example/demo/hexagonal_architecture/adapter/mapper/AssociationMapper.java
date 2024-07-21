
package com.example.demo.hexagonal_architecture.adapter.mapper;

import com.example.demo.hexagonal_architecture.adapter.dto.FieldDTO;
import com.example.demo.hexagonal_architecture.adapter.intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.AssociationDTO;
import com.example.demo.hexagonal_architecture.core.enitity.AssociationEntity;
import com.example.demo.hexagonal_architecture.core.enitity.Field;
import com.example.demo.hexagonal_architecture.core.enitity.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AssociationMapper implements DtoMapper<AssociationEntity, AssociationDTO> {
    private static final Logger logger = LoggerFactory.getLogger(AssociationMapper.class);

    @Override
    public AssociationEntity apply(AssociationDTO associationDto) {
        AssociationEntity associationEntity = new AssociationEntity();
        associationEntity.setId(associationDto.getId());
        associationEntity.setFields(
                associationDto.getFields()
                        .stream()
                        .map(fieldDTO -> mapToFieldEntity(fieldDTO, associationEntity))
                        .collect(Collectors.toList())
        );
        associationEntity.setFinalSolutions(associationDto.getFinalSolutions());
        associationEntity.setSolutions(associationDto.getSolutions());
        return associationEntity;
    }

    private Field mapToFieldEntity(FieldDTO fieldDTO, AssociationEntity associationEntity) {
        Field fieldEntity = new Field();
        fieldEntity.setText(fieldDTO.getText());
        if (fieldDTO.getPosition() != null) {
            fieldEntity.setPosition(Position.valueOf(fieldDTO.getPosition()));
        } else {
            fieldEntity.setPosition(null);
        }
        fieldEntity.setAssociation(associationEntity); // Postavi association
        return fieldEntity;
    }
}
