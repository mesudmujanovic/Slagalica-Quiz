package com.example.demo.hexagonal_architecture.adapter.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovePayload {
    private String player;
    private int number;
}