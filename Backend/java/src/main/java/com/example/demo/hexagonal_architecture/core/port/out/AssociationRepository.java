package com.example.demo.hexagonal_architecture.core.port.out;

import com.example.demo.hexagonal_architecture.core.enitity.AssociationEntity;
import com.example.demo.hexagonal_architecture.core.enitity.Field;

import java.util.List;
import java.util.Optional;


public interface AssociationRepository {

    AssociationEntity saveAssociation(AssociationEntity associationEntity);
    List<AssociationEntity> getAll();

    Optional<Field> getFieldByPosition(String position);
}
