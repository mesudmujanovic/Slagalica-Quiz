package com.example.demo.hexagonal_architecture.core.port.out.persistence.guessTheWordsEntity;

import com.example.demo.hexagonal_architecture.core.enitity.guessTheWordsEntity.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaWord extends JpaRepository<Word, Long> {
}
