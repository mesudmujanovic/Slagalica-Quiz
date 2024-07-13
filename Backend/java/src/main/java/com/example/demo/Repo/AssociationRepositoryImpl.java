package com.example.demo.Repo;

import com.example.demo.Enitity.AssociationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class AssociationRepositoryImpl implements AssociationRepository{

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
