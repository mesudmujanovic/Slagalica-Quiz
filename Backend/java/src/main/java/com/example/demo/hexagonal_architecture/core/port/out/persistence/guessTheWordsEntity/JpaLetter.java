package com.example.demo.hexagonal_architecture.core.port.out.persistence.guessTheWordsEntity;

import com.example.demo.hexagonal_architecture.core.enitity.guessTheWordsEntity.Letter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLetter extends JpaRepository<Letter, Long> {
}
