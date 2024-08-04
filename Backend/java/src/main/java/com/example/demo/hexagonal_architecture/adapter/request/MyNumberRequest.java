package com.example.demo.hexagonal_architecture.adapter.request;

import lombok.Data;

@Data
public class MyNumberRequest {
   private String player1;
   private String player2;
   private int result;
}
