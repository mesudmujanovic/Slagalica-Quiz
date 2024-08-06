package com.example.demo.hexagonal_architecture.core.port.out.persistenceJpa;

import com.example.demo.hexagonal_architecture.core.enitity.LetterWordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LetterWordJpa extends JpaRepository<LetterWordEntity, Long> {
}
