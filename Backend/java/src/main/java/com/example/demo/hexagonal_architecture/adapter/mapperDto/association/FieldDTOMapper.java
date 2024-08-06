package com.example.demo.hexagonal_architecture.adapter.mapperDto.association;

import com.example.demo.hexagonal_architecture.adapter.dto.association.FieldDTO;
import com.example.demo.hexagonal_architecture.adapter.intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.core.enitity.association.Field;
import com.example.demo.hexagonal_architecture.core.enitity.association.Position;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class FieldDTOMapper implements DtoMapper<FieldDTOMapper, Field> {

    @Override
    public FieldDTO apply(Field fieldEntity) {
        FieldDTO fieldDTO = new FieldDTO();
        fieldDTO.setText(fieldEntity.getText());
        fieldDTO.setColumnPosition(fieldEntity.getColumnPosition());
        Optional.ofNullable(fieldEntity.getPosition())
                .map(Position::name)
                .ifPresent(fieldDTO::setPosition);
        return fieldDTO;
    }
}
