package com.example.demo.hexagonal_architecture.adapter.Request;

import lombok.Data;

import java.util.List;

@Data
public class AssociationRequest {
    private List<String> columnA;

    private List<String> columnB;

    private List<String> columnC;

    private List<String> columnD;

    private List<String> solutions;

    private List<String> finallSolutions;

}
