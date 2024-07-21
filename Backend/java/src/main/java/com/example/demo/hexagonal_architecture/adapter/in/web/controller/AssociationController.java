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
@RequestMapping("/associations-game")
@RequiredArgsConstructor
public class AssociationController {

    private final AssociationService associationService;

    @PostMapping("/association")
    public ResponseEntity<AssociationResponse> saveAssociation(@RequestBody AssociationRequest associationRequest) {
        // Pretvaranje AssociationRequest u AssociationDTO
        AssociationDTO associationDto = AssociationDTO.fromRequestToDto(associationRequest);

        // Čuvanje AssociationDTO i vraćanje sačuvanog DTO-a
        AssociationDTO savedAssociationDto = associationService.saveAssociation(associationDto);

        // Pretvaranje AssociationDTO u AssociationResponse
        AssociationResponse associationResponse = AssociationDTO.fromDtoToAssociationResponse(savedAssociationDto);

        // Vraćanje ResponseEntity sa AssociationResponse
        return ResponseEntity.ok(associationResponse);
    }

    @GetMapping("/associations")
    public ResponseEntity<List<AssociationResponse>> getAll() {
        List<AssociationDTO> associationDTOs = associationService.getAll();
        List<AssociationResponse> associationResponses = associationDTOs.stream()
                .map(AssociationDTO::fromDtoToAssociationResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(associationResponses);
    }
}