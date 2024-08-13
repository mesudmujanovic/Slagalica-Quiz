package com.example.demo.hexagonal_architecture.adapter.response;

import lombok.Data;
import java.util.List;

@Data
public class LetterWordResponse {

    private Long id;
    private List<String> letters;
    private List<String> words;
}
