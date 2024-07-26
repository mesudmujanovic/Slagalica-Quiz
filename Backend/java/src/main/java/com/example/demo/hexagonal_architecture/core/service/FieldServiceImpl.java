package com.example.demo.hexagonal_architecture.core.service;

import com.example.demo.hexagonal_architecture.adapter.dto.FieldDTO;
import com.example.demo.hexagonal_architecture.adapter.mapperDto.FieldDTOMapper;
import com.example.demo.hexagonal_architecture.core.enitity.Field;
import com.example.demo.hexagonal_architecture.core.enitity.Position;
import com.example.demo.hexagonal_architecture.core.port.out.FieldAssocRepository;
import com.example.demo.hexagonal_architecture.core.port.out.in.FieldService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

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
}
