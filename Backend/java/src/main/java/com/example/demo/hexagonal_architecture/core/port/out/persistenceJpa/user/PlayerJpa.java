package com.example.demo.hexagonal_architecture.core.port.out.persistenceJpa.user;

import com.example.demo.hexagonal_architecture.core.enitity.user.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerJpa extends JpaRepository<PlayerEntity, Long> {}
