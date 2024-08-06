package com.example.demo.hexagonal_architecture.adapter.out.repository;


import com.example.demo.hexagonal_architecture.core.enitity.SymbolMastermindEntity;
import com.example.demo.hexagonal_architecture.core.port.out.SymbolMastermindRepository;
import com.example.demo.hexagonal_architecture.core.port.out.persistenceJpa.SymbolMastermindJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SymbolMastermindImpl implements SymbolMastermindRepository {
    private final SymbolMastermindJpa symbolMastermindJpa;
    @Override
    public SymbolMastermindEntity createSymbolMastermind(SymbolMastermindEntity symbolMastermindEntity, MultipartFile multipartFile) {
        return symbolMastermindJpa.save(symbolMastermindEntity);
    }

    @Override
    public List<SymbolMastermindEntity> getAllSymbolMastermind() {
        return symbolMastermindJpa.findAll();
    }
}
