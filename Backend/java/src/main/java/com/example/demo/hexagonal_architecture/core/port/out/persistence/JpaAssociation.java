package com.example.demo.hexagonal_architecture.core.port.out.persistence;

import com.example.demo.hexagonal_architecture.core.enitity.AssociationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaAssociation extends JpaRepository<AssociationEntity, Long> {

    @Query("SELECT a FROM AssociationEntity a JOIN a.fields f WHERE a.id = :id AND f.position = :position")
    Optional<AssociationEntity> findByFieldsPosition(@Param("id") Long id, @Param("position") String position);
}
