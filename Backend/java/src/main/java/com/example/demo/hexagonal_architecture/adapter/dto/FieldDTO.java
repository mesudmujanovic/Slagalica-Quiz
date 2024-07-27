package com.example.demo.hexagonal_architecture.adapter.dto;

import com.example.demo.hexagonal_architecture.adapter.request.FieldRequest;
import com.example.demo.hexagonal_architecture.adapter.response.FieldResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldDTO {
    private Long id;
    private String text;
    private String columnPosition;
    private String position;

    public static FieldDTO fromRequestToDto(FieldRequest fieldRequest) {
        FieldDTO fieldDTO = new FieldDTO();
        fieldDTO.setId(fieldRequest.getId());
        fieldDTO.setText(fieldRequest.getText());
        fieldDTO.setColumnPosition(fieldRequest.getColumnPosition());
        fieldDTO.setPosition(fieldRequest.getPosition());
        return fieldDTO;
    }

    public static FieldResponse fromDtoToResponse(FieldDTO fieldDTO) {
        FieldResponse fieldResponse = new FieldResponse();
        fieldResponse.setText(fieldDTO.getText());
        fieldResponse.setColumnPosition(fieldDTO.getColumnPosition());
        fieldResponse.setPosition(fieldDTO.getPosition());
        return fieldResponse;
    }
}