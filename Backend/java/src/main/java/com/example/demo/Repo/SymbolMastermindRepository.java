package com.example.demo.Repo;

import com.example.demo.Enitity.SymbolMastermind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymbolMastermindRepository extends JpaRepository<SymbolMastermind, Long> {
}
