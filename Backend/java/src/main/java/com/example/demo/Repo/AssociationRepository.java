package com.example.demo.Repo;

import com.example.demo.Enitity.AssociationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AssociationRepository {

    AssociationEntity saveAssociation(AssociationEntity associationEntity);

    List<AssociationEntity> getAll();
}
