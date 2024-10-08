package com.example.demo.hexagonal_architecture.adapter.dto.association;

import com.example.demo.hexagonal_architecture.adapter.request.association.AssociationRequest;
import com.example.demo.hexagonal_architecture.adapter.response.association.AssociationResponse;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class AssociationDTO {
    private Long id;
    private List<FieldDTO> fields;
    private String finalSolutions;
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
