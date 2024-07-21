package com.example.demo.hexagonal_architecture.adapter.response;

import com.example.demo.hexagonal_architecture.adapter.dto.FieldDTO;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class AssociationResponse {
    private Long id;
    private List<FieldDTO> fields;
    private List<String> finalSolutions;
    private Map<String, String> solutions;
}