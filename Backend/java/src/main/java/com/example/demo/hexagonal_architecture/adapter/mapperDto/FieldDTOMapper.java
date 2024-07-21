package com.example.demo.hexagonal_architecture.adapter.mapperDto;

import com.example.demo.hexagonal_architecture.adapter.dto.FieldDTO;
import com.example.demo.hexagonal_architecture.adapter.intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.core.enitity.Field;
import com.example.demo.hexagonal_architecture.core.enitity.Position;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FieldDTOMapper implements DtoMapper<FieldDTOMapper, Field> {

    @Override
    public FieldDTO apply(Field fieldEntity) {
        FieldDTO fieldDTO = new FieldDTO();
        fieldDTO.setText(fieldEntity.getText());
        Optional.ofNullable(fieldEntity.getPosition())
                .map(Position::name)
                .ifPresent(fieldDTO::setPosition);
        return fieldDTO;
    }

}
