package com.example.demo.hexagonal_architecture.adapter.in.web.controller;

import com.example.demo.hexagonal_architecture.core.port.out.in.AssociationService;
import com.example.demo.hexagonal_architecture.adapter.request.AssociationRequest;
import com.example.demo.hexagonal_architecture.adapter.response.AssociationResponse;
import com.example.demo.hexagonal_architecture.adapter.dto.AssociationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/assoc")
@RequiredArgsConstructor
public class AssociationController {

    private final AssociationService associationService;

    @PostMapping("/save")
    public ResponseEntity<AssociationResponse> saveAssociation(@RequestBody AssociationRequest associationRequest) {
        AssociationDTO associationDto = AssociationDTO.fromRequestToDto(associationRequest);
        AssociationDTO associationDTOSave = associationService.saveAssociation(associationDto);
        return ResponseEntity.ok(associationDTOSave.fromDtoToAssociationResponse());
    }

    @GetMapping("/all")
    public ResponseEntity<List<AssociationResponse>> getAll() {
        List<AssociationDTO> associationDTOS = associationService.getAll();
        return ResponseEntity.ok(associationDTOS.stream()
                .map(AssociationDTO::fromDtoToAssociationResponse)
                .collect(Collectors.toList()));
    }
}