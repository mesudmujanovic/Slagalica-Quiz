package com.example.demo.hexagonal_architecture.adapter.response;

import lombok.Data;

@Data
public class PlayerResponse {

    private Long id;
    private Long userId;
    private int totalScore;
}
