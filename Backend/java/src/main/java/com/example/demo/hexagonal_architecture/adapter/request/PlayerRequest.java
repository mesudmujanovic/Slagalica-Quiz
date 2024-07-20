package com.example.demo.hexagonal_architecture.adapter.request;

import lombok.Data;

@Data
public class PlayerRequest {

    private Long userAuthId;
    private int totalScore;
}
