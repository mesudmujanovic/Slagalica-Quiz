package com.example.demo.hexagonal_architecture.adapter.out.repository;

import com.example.demo.hexagonal_architecture.core.port.out.AssociationRepository;
import com.example.demo.hexagonal_architecture.core.enitity.AssociationEntity;
import com.example.demo.hexagonal_architecture.core.port.out.persistence.JpaAssociation;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AssociationRepositoryImpl implements AssociationRepository {
    private final JpaAssociation jpaAssociation;
    public AssociationRepositoryImpl(JpaAssociation jpaAssociation) {
        this.jpaAssociation = jpaAssociation;
    }

    @Override
    public AssociationEntity saveAssociation(AssociationEntity associationEntity) {
        return jpaAssociation.save(associationEntity);
    }

    @Override
    public List<AssociationEntity> getAll() {
        return jpaAssociation.findAll();
    }
}
