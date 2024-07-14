package com.example.demo.hexagonal_architecture.adapter.out.repository;

import com.example.demo.hexagonal_architecture.core.port.out.AssociationRepository;
import com.example.demo.hexagonal_architecture.core.Enitity.AssociationEntity;
import com.example.demo.hexagonal_architecture.core.port.out.persistence.JpaAssociationRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssociationRepositoryImpl implements AssociationRepository {

    private final JpaAssociationRepo jpaAssociationRepo;

    public AssociationRepositoryImpl(JpaAssociationRepo jpaAssociationRepo) {
        this.jpaAssociationRepo = jpaAssociationRepo;
    }

    @Override
    public AssociationEntity saveAssociation(AssociationEntity associationEntity) {
        return jpaAssociationRepo.save(associationEntity);
    }

    @Override
    public List<AssociationEntity> getAll() {
        return jpaAssociationRepo.findAll();
    }
}
