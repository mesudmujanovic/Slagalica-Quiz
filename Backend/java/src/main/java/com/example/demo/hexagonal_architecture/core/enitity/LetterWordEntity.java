package com.example.demo.hexagonal_architecture.core.enitity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LetterWordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "letter_characters", joinColumns = @JoinColumn(name = "letter_word_id"))
    private List<String> letters = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "word_list", joinColumns = @JoinColumn(name = "letter_word_id"))
    private List<String> words = new ArrayList<>();
}
