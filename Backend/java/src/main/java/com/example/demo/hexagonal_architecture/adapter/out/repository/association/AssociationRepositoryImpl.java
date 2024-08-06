package com.example.demo.hexagonal_architecture.adapter.out.repository.association;

import com.example.demo.hexagonal_architecture.core.port.out.AssociationRepository;
import com.example.demo.hexagonal_architecture.core.enitity.association.AssociationEntity;
import com.example.demo.hexagonal_architecture.core.port.out.persistence.association.JpaAssociation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AssociationRepositoryImpl implements AssociationRepository {
    private final JpaAssociation jpaAssociation;

    @Override
    public AssociationEntity saveAssociation(AssociationEntity associationEntity) {
        return jpaAssociation.save(associationEntity);
    };

    @Override
    public List<AssociationEntity> getAll() {
        return jpaAssociation.findAll();
    };

    @Override
    public Optional<AssociationEntity> findById(Long id) {
        return jpaAssociation.findById(id);
    };

}
