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
public class Letter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "letter_characters", joinColumns = @JoinColumn(name = "letter_id"))
    @Column(name = "letter_character")
    private List<String> characters;

    @ManyToMany
    @JoinTable(
            name = "letter_words",
            joinColumns = @JoinColumn(name = "letter_id"),
            inverseJoinColumns = @JoinColumn(name = "word_id")
    )
    private List<Word> words;
}
