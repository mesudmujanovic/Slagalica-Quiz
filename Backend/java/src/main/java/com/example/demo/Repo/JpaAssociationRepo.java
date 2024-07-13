package com.example.demo.Repo;

import com.example.demo.Enitity.AssociationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAssociationRepo extends JpaRepository<AssociationEntity, Long> {
}
