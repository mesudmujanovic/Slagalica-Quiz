package com.example.demo.hexagonal_architecture.adapter.response.association;

import com.example.demo.hexagonal_architecture.adapter.dto.association.FieldDTO;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class AssociationResponse {
    private Long id;
    private List<FieldDTO> fields;
    private String finalSolutions;
    private Map<String, String> solutions;
}