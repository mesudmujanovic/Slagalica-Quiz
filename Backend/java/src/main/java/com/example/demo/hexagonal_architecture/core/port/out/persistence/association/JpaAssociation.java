package com.example.demo.hexagonal_architecture.core.port.out.persistence.association;

import com.example.demo.hexagonal_architecture.core.enitity.association.AssociationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAssociation extends JpaRepository<AssociationEntity, Long> {
}
