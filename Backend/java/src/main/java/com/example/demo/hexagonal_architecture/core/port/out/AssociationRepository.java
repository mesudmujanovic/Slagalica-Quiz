package com.example.demo.hexagonal_architecture.core.port.out;

import com.example.demo.hexagonal_architecture.core.enitity.AssociationEntity;

import java.util.List;


public interface AssociationRepository {

    AssociationEntity saveAssociation(AssociationEntity associationEntity);

    List<AssociationEntity> getAll();
}
