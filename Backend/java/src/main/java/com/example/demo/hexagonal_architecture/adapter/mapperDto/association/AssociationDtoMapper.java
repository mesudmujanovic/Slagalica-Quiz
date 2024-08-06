package com.example.demo.hexagonal_architecture.adapter.mapperDto.association;

import com.example.demo.hexagonal_architecture.adapter.intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.association.AssociationDTO;
import com.example.demo.hexagonal_architecture.core.enitity.association.AssociationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AssociationDtoMapper implements DtoMapper<AssociationDTO, AssociationEntity> {

    private final FieldDTOMapper fieldDTOMapper;

    @Override
    public AssociationDTO apply(AssociationEntity associationEntity) {
        AssociationDTO associationDto = new AssociationDTO();
        associationDto.setId(associationEntity.getId());
        associationDto.setFields(
                associationEntity.getFields().stream()
                        .map(fieldDTOMapper::apply)
                        .collect(Collectors.toList())
        );
        associationDto.setFinalSolutions(associationEntity.getFinalSolutions());
        associationDto.setSolutions(associationEntity.getSolutions());
        return associationDto;
    }
}