package com.example.demo.hexagonal_architecture.adapter.response;

import lombok.Data;

@Data
public class UserInfoContactResponse {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
}
