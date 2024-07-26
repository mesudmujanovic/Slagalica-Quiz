package com.example.demo.hexagonal_architecture.adapter.out.repository;

import com.example.demo.hexagonal_architecture.core.enitity.Field;
import com.example.demo.hexagonal_architecture.core.enitity.Position;
import com.example.demo.hexagonal_architecture.core.port.out.FieldAssocRepository;
import com.example.demo.hexagonal_architecture.core.port.out.persistence.JpaField;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FieldAssocRepositoryImpl implements FieldAssocRepository {
    private final JpaField jpaField;
    @Override
    public Optional<Field> findByPosition(Long associationId, Position position) {
        return jpaField.findFieldByPosition(associationId, position);
    }
}
