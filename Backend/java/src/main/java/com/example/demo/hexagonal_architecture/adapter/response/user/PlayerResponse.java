package com.example.demo.hexagonal_architecture.adapter.response.user;

import lombok.Data;

@Data
public class PlayerResponse {

    private Long id;
    private Long userId;
    private int totalScore;
}
