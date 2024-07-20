package com.example.demo.hexagonal_architecture.adapter.out.repository;


import com.example.demo.hexagonal_architecture.core.enitity.SymbolMastermind;
import com.example.demo.hexagonal_architecture.core.port.out.SymbolMastermindRepository;
import com.example.demo.hexagonal_architecture.core.port.out.persistence.JpaSymbolMastermind;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SymbolMastermindImpl implements SymbolMastermindRepository {
    private final JpaSymbolMastermind jpaSymbolMastermind;
    @Override
    public SymbolMastermind createSymbolMastermind(SymbolMastermind symbolMastermind, MultipartFile multipartFile) {
        return jpaSymbolMastermind.save(symbolMastermind);
    }

    @Override
    public List<SymbolMastermind> getAllSymbolMastermind() {
        return jpaSymbolMastermind.findAll();
    }
}
