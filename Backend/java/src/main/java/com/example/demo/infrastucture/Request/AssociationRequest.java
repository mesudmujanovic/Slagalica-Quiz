package com.example.demo.infrastucture.Request;

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
