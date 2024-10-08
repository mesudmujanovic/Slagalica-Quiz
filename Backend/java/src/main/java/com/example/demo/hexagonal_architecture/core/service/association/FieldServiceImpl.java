package com.example.demo.hexagonal_architecture.core.service.association;

import com.example.demo.hexagonal_architecture.adapter.dto.association.FieldDTO;
import com.example.demo.hexagonal_architecture.adapter.mapperDto.association.FieldDTOMapper;
import com.example.demo.hexagonal_architecture.core.enitity.association.Field;
import com.example.demo.hexagonal_architecture.core.enitity.association.Position;
import com.example.demo.hexagonal_architecture.core.port.out.FieldAssocRepository;
import com.example.demo.hexagonal_architecture.core.port.out.in.association.FieldService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
@RequiredArgsConstructor
public class FieldServiceImpl implements FieldService {
    private final FieldAssocRepository fieldRepository;
    private final FieldDTOMapper fieldDTOMapper;

    @Override
    public Optional<FieldDTO> findByPosition(Long associationId, Position position) {
        Optional<Field> fieldOptional = fieldRepository.findByPosition(associationId, position);
        return fieldOptional.map(fieldDTOMapper::apply);
    }

    @Override
    public List<FieldDTO> findByAssociationIdAndColumnPosition(Long associationId, String columnPosition) {
        List<Field> fieldEntities = fieldRepository.findByAssociationIdAndColumnPosition(associationId, columnPosition);
        return fieldEntities.stream()
                .map(fieldDTOMapper::apply)
                .collect(Collectors.toList());
    }
}
