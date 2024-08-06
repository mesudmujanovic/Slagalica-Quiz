package com.example.demo.hexagonal_architecture.core.enitity.guessTheWordsEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "word_list", joinColumns = @JoinColumn(name = "word_id"))
    @Column(name = "word")
    private List<String> words;
}
