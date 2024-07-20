package com.example.demo.hexagonal_architecture.core.port.out.persistence;

import com.example.demo.hexagonal_architecture.core.enitity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPlayer extends JpaRepository<PlayerEntity, Long> {}
