package com.example.demo.hexagonal_architecture.adapter.out.repository.association;

import com.example.demo.hexagonal_architecture.core.enitity.association.Field;
import com.example.demo.hexagonal_architecture.core.enitity.association.Position;
import com.example.demo.hexagonal_architecture.core.port.out.FieldAssocRepository;
import com.example.demo.hexagonal_architecture.core.port.out.persistenceJpa.association.FieldJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FieldAssocRepositoryImpl implements FieldAssocRepository {
    private final FieldJpa fieldJpa;
    @Override
    public Optional<Field> findByPosition(Long associationId, Position position) {
        return fieldJpa.findFieldByPosition(associationId, position);
    }

    @Override
    public List<Field> findByAssociationIdAndColumnPosition(Long associationId, String columnPosition) {
        return fieldJpa.findByAssociationIdAndColumnPosition(associationId, columnPosition);
    }


}
