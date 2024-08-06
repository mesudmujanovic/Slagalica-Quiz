package com.example.demo.hexagonal_architecture.adapter.request.user;

import lombok.Data;

@Data
public class PlayerRequest {
    private Long id;
    private Long userAuthId;
    private int totalScore;
}
