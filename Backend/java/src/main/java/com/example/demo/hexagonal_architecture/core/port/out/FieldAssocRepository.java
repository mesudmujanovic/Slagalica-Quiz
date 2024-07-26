package com.example.demo.hexagonal_architecture.core.port.out;

import com.example.demo.hexagonal_architecture.core.enitity.Field;
import com.example.demo.hexagonal_architecture.core.enitity.Position;
import java.util.Optional;

public interface FieldAssocRepository {
    Optional<Field> findByPosition(Long associationId, Position position);
}
