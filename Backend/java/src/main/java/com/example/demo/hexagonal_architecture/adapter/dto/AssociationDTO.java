package com.example.demo.hexagonal_architecture.adapter.dto;

import com.example.demo.hexagonal_architecture.adapter.request.AssociationRequest;
import com.example.demo.hexagonal_architecture.adapter.response.AssociationResponse;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class AssociationDTO {
    private Long id;
    private List<FieldDTO> fields;
    private List<String> finalSolutions;
    private Map<String, String> solutions;

    public static AssociationDTO fromRequestToDto(AssociationRequest associationRequest) {
        AssociationDTO associationDto = new AssociationDTO();
        associationDto.setFields(associationRequest.getFields());
        associationDto.setFinalSolutions(associationRequest.getFinalSolutions());
        associationDto.setSolutions(associationRequest.getSolutions());
        return associationDto;
    }

    public static AssociationResponse fromDtoToAssociationResponse(AssociationDTO associationDTO) {
        AssociationResponse associationResponse = new AssociationResponse();
        associationResponse.setId(associationDTO.getId());
        associationResponse.setFields(associationDTO.getFields());
        associationResponse.setFinalSolutions(associationDTO.getFinalSolutions());
        associationResponse.setSolutions(associationDTO.getSolutions());
        return associationResponse;
    }

}
