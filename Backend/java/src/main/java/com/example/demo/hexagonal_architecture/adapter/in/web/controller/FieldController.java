package com.example.demo.hexagonal_architecture.adapter.in.web.controller;

import com.example.demo.hexagonal_architecture.adapter.dto.FieldDTO;
import com.example.demo.hexagonal_architecture.adapter.response.FieldResponse;
import com.example.demo.hexagonal_architecture.core.enitity.Field;
import com.example.demo.hexagonal_architecture.core.enitity.Position;
import com.example.demo.hexagonal_architecture.core.service.FieldServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/fields")
@RequiredArgsConstructor
public class FieldController {
    private final FieldServiceImpl fieldServiceImpl;

    @GetMapping("/search/{associationId}/{position}")
    public ResponseEntity<FieldResponse> findFieldByAssociationIdAndPosition(
            @PathVariable Long associationId,
            @PathVariable Position position) {
        Optional<FieldDTO> fieldDTOOptional = fieldServiceImpl.findByPosition(associationId, position);
        return fieldDTOOptional
                .map(fieldDTO -> ResponseEntity.ok(FieldDTO.fromDtoToResponse(fieldDTO)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/association/{associationId}/column/{columnPosition}")
    public ResponseEntity<List<FieldResponse>> getFieldByAssociationIdAndColumnPosition(
            @PathVariable Long associationId,
            @PathVariable String columnPosition) {
        List<FieldDTO> fieldDTOs = fieldServiceImpl.findByAssociationIdAndColumnPosition(associationId, columnPosition);

        if (fieldDTOs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        List<FieldResponse> fieldResponses = fieldDTOs.stream()
                .map(FieldDTO::fromDtoToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(fieldResponses);
    }
}
