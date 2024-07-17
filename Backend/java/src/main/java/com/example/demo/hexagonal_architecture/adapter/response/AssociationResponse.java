package com.example.demo.hexagonal_architecture.adapter.response;

import lombok.Data;

import java.util.List;

@Data
public class AssociationResponse {

    private Long id;
    private List<String> columnA;

    private List<String> columnB;

    private List<String> columnC;

    private List<String> columnD;

    private List<String> solutions;

    private List<String> finallSolutions;
}
