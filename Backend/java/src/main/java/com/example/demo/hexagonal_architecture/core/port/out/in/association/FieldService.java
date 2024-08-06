package com.example.demo.hexagonal_architecture.core.port.out.in.association;

import com.example.demo.hexagonal_architecture.adapter.dto.association.FieldDTO;
import com.example.demo.hexagonal_architecture.core.enitity.association.Position;

import java.util.List;
import java.util.Optional;

public interface FieldService {
    Optional<FieldDTO> findByPosition(Long associationId, Position position);
    List<FieldDTO> findByAssociationIdAndColumnPosition(Long associationId, String columnPosition);
}
