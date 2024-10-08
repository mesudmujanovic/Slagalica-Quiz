package com.example.demo.hexagonal_architecture.adapter.request.user;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    private String username;
    private String password;
}