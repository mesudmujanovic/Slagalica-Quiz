package com.example.demo.hexagonal_architecture.adapter.mapper.association;

import com.example.demo.hexagonal_architecture.adapter.intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.association.AssociationDTO;
import com.example.demo.hexagonal_architecture.core.enitity.association.AssociationEntity;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

import static com.example.demo.hexagonal_architecture.adapter.mapper.association.FieldMapper.mapToFieldEntity;

@Component
public class AssociationMapper implements DtoMapper<AssociationEntity, AssociationDTO> {

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
}
