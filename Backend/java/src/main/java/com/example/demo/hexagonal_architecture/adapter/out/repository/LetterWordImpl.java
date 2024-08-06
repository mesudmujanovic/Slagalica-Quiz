package com.example.demo.hexagonal_architecture.adapter.out.repository;

import com.example.demo.hexagonal_architecture.core.enitity.LetterWordEntity;
import com.example.demo.hexagonal_architecture.core.port.out.LetterWordRepository;
import com.example.demo.hexagonal_architecture.core.port.out.persistenceJpa.LetterWordJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class LetterWordImpl implements LetterWordRepository {

    private final LetterWordJpa letterWordJpa;

    @Override
    public LetterWordEntity saveLetterWord(LetterWordEntity letterWordEntity) {
        return letterWordJpa.save(letterWordEntity);
    }

    @Override
    public List<LetterWordEntity> getAll() {
        return letterWordJpa.findAll();
    }
}
