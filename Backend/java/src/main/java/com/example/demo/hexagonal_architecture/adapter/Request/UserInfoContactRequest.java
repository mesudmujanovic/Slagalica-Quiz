package com.example.demo.hexagonal_architecture.adapter.Request;

import lombok.Data;

@Data
public class UserInfoContactRequest {


    private String name;

    private String lastName;


    private String email;

    private String phone;
}