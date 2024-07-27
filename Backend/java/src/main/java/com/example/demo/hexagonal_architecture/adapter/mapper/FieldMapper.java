package com.example.demo.hexagonal_architecture.adapter.mapper;

import com.example.demo.hexagonal_architecture.adapter.dto.FieldDTO;
import com.example.demo.hexagonal_architecture.core.enitity.AssociationEntity;
import com.example.demo.hexagonal_architecture.core.enitity.Field;
import com.example.demo.hexagonal_architecture.core.enitity.Position;
import org.springframework.stereotype.Component;
import java.util.Optional;
@Component
public class FieldMapper {
      public static Field mapToFieldEntity(FieldDTO fieldDTO, AssociationEntity associationEntity) {
        Field fieldEntity = new Field();
        fieldEntity.setText(fieldDTO.getText());
        fieldEntity.setColumnPosition(fieldDTO.getColumnPosition());
        Optional.ofNullable(fieldDTO.getPosition())
                .map(Position::valueOf)
                .ifPresentOrElse(
                        fieldEntity::setPosition,
                        () -> fieldEntity.setPosition(null)
                );
        fieldEntity.setAssociation(associationEntity);
        return fieldEntity;
    }
}
