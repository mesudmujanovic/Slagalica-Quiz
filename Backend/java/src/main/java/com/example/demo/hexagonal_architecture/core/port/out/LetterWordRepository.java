package com.example.demo.hexagonal_architecture.core.port.out;

import com.example.demo.hexagonal_architecture.core.enitity.LetterWordEntity;

import java.util.List;
import java.util.Optional;

public interface LetterWordRepository {
    LetterWordEntity saveLetterWord (LetterWordEntity letterWordEntity);

    List<LetterWordEntity> getAll();

    Optional<LetterWordEntity> findById(Long letterWordId);
}
