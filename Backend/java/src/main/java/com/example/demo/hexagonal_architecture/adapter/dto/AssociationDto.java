package com.example.demo.hexagonal_architecture.adapter.dto;

import com.example.demo.hexagonal_architecture.adapter.request.AssociationRequest;
import com.example.demo.hexagonal_architecture.adapter.response.AssociationResponse;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class AssociationDto {

    private Long id;
    private List<String> columnA;

    private List<String> columnB;

    private List<String> columnC;

    private List<String> columnD;

    private Map<String, String> solutions;

    private List<String> finallSolutions;

    public static AssociationDto fromRequestToDto(AssociationRequest associationRequest){
        AssociationDto associationDto = new AssociationDto();
        associationDto.setColumnA(associationRequest.getColumnA());
        associationDto.setColumnB(associationRequest.getColumnB());
        associationDto.setColumnC(associationRequest.getColumnC());
        associationDto.setColumnD(associationRequest.getColumnD());
        Map<String, String> solutionsMap = new HashMap<>();
        for (String solution : associationRequest.getSolutions()) {
            solutionsMap.put("custom_key_" + solutionsMap.size(), solution);
        }
        associationDto.setSolutions(solutionsMap);
        associationDto.setFinallSolutions(associationRequest.getFinallSolutions());
        return associationDto;
    }

    public AssociationResponse fromDtoToAssociationResponse(){
        AssociationResponse associationResponse = new AssociationResponse();
        associationResponse.setId(this.getId());
        associationResponse.setColumnA(this.getColumnA());
        associationResponse.setColumnB(this.getColumnB());
        associationResponse.setColumnC(this.getColumnC());
        associationResponse.setColumnD(this.getColumnD());
        List<String> solutionsList = convertMapToList(this.getSolutions());
        associationResponse.setSolutions(solutionsList);
        associationResponse.setFinallSolutions(this.getFinallSolutions());
        return associationResponse;
    }
    private List<String> convertMapToList(Map<String, String> solutionsMap) {
        List<String> solutionsList = new ArrayList<>();
        solutionsMap.forEach((key, value) -> solutionsList.add(key + ": " + value));
        return solutionsList;
    }
}
