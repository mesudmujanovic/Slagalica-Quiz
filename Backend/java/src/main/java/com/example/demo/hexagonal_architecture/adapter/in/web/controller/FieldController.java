package com.example.demo.hexagonal_architecture.adapter.in.web.controller;

import com.example.demo.hexagonal_architecture.adapter.dto.FieldDTO;
import com.example.demo.hexagonal_architecture.adapter.response.FieldResponse;
import com.example.demo.hexagonal_architecture.core.enitity.Position;
import com.example.demo.hexagonal_architecture.core.service.FieldServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

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
}