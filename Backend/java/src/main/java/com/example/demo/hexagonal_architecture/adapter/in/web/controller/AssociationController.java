package com.example.demo.hexagonal_architecture.adapter.in.web.controller;

import com.example.demo.hexagonal_architecture.adapter.response.MessageResponse;
import com.example.demo.hexagonal_architecture.core.exception.CorrectSolutionException;
import com.example.demo.hexagonal_architecture.core.exception.IncorrectSolutionException;
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
        AssociationDTO associationDto = AssociationDTO.fromRequestToDto(associationRequest);
        AssociationDTO savedAssociationDto = associationService.saveAssociation(associationDto);
        AssociationResponse associationResponse = AssociationDTO.fromDtoToAssociationResponse(savedAssociationDto);
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
    @GetMapping("/checkSolution/{associationId}/{column}/{userInput}")
    public ResponseEntity<MessageResponse> checkSolution(
            @PathVariable Long associationId,
            @PathVariable String column,
            @PathVariable String userInput) {
        boolean isSolutionCorrect = associationService.checkSolution(associationId, column, userInput);
        if (isSolutionCorrect) {
            throw new CorrectSolutionException();
        } else {
            throw new IncorrectSolutionException();
        }
    }

    @GetMapping("/checkFinalSolution/{associationId}/{userInput}")
    public ResponseEntity<Boolean> checkFinalSolution(
            @PathVariable Long associationId,
            @PathVariable String userInput) {
        boolean isCorrect = associationService.checkFinalSolution(associationId, userInput);
        if (isCorrect) {
            throw new CorrectSolutionException();
        } else {
            throw new IncorrectSolutionException();
        }
    }
}