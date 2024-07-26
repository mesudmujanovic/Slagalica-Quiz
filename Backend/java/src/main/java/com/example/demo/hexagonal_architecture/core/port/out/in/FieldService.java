package com.example.demo.hexagonal_architecture.core.port.out.in;

import com.example.demo.hexagonal_architecture.adapter.dto.FieldDTO;
import com.example.demo.hexagonal_architecture.core.enitity.Position;
import java.util.Optional;

public interface FieldService {
    Optional<FieldDTO> findByPosition(Long associationId, Position position);
}
