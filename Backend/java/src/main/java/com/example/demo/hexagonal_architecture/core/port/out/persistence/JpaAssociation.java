package com.example.demo.hexagonal_architecture.core.port.out.persistence;

import com.example.demo.hexagonal_architecture.core.enitity.AssociationEntity;
import com.example.demo.hexagonal_architecture.core.enitity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaAssociation extends JpaRepository<AssociationEntity, Long> {
    @Query("SELECT f FROM AssociationEntity a JOIN a.fields f WHERE f.position = :position")
    Optional<Field> findFieldByPosition(@Param("position") String position);
}
