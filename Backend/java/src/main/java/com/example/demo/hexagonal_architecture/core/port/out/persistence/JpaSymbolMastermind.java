package com.example.demo.hexagonal_architecture.core.port.out.persistence;

import com.example.demo.hexagonal_architecture.core.enitity.SymbolMastermind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSymbolMastermind extends JpaRepository<SymbolMastermind, Long> {
}
