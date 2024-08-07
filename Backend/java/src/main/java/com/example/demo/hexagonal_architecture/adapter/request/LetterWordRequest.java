package com.example.demo.hexagonal_architecture.adapter.request;

import lombok.Data;

import java.util.List;

@Data
public class LetterWordRequest {

    private Long id;
    private List<String> letters;
    private List<String> words;
}
