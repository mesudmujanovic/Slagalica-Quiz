package com.example.demo.hexagonal_architecture.core.port.out.persistenceJpa.association;

import com.example.demo.hexagonal_architecture.core.enitity.association.Field;
import com.example.demo.hexagonal_architecture.core.enitity.association.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface FieldJpa extends JpaRepository<Field, Long> {
    @Query("SELECT f FROM AssociationEntity a JOIN a.fields f WHERE a.id = :associationId AND f.position = :position")
    Optional<Field> findFieldByPosition(@Param("associationId") Long associationId, @Param("position") Position position);
    List<Field> findByAssociationIdAndColumnPosition(Long associationId, String columnPosition);
}
