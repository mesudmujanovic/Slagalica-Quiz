package com.example.demo.hexagonal_architecture.core.port.out.in;

import com.example.demo.hexagonal_architecture.adapter.dto.FieldDTO;
import com.example.demo.hexagonal_architecture.core.enitity.Position;

import java.util.List;
import java.util.Optional;

public interface FieldService {
    Optional<FieldDTO> findByPosition(Long associationId, Position position);
    List<FieldDTO> findByAssociationIdAndColumnPosition(Long associationId, String columnPosition);
}
