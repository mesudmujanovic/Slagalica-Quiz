package com.example.demo.hexagonal_architecture.adapter.request;

import com.example.demo.hexagonal_architecture.adapter.dto.FieldDTO;
import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class AssociationRequest {
        private List<FieldDTO> fields;
        private String finalSolutions;
        private Map<String, String> solutions;
}

