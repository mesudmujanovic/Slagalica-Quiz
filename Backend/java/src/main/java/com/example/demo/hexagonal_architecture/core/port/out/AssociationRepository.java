package com.example.demo.hexagonal_architecture.core.port.out;

import com.example.demo.hexagonal_architecture.core.Enitity.AssociationEntity;

import java.util.List;


public interface AssociationRepository {

    AssociationEntity saveAssociation(AssociationEntity associationEntity);

    List<AssociationEntity> getAll();
}
