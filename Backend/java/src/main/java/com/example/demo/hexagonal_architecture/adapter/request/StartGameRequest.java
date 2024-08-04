package com.example.demo.hexagonal_architecture.adapter.request;

import lombok.Data;

@Data
public class StartGameRequest {
    private String player1;
    private String player2;
}