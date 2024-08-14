package com.example.demo.hexagonal_architecture.adapter.in.web.controller.Association;

import com.example.demo.hexagonal_architecture.adapter.response.MessageResponse;
import com.example.demo.hexagonal_architecture.core.exception.CorrectSolutionException;
import com.example.demo.hexagonal_architecture.core.exception.IncorrectSolutionException;
import com.example.demo.hexagonal_architecture.core.port.out.in.association.AssociationService;
import com.example.demo.hexagonal_architecture.adapter.request.association.AssociationRequest;
import com.example.demo.hexagonal_architecture.adapter.response.association.AssociationResponse;
import com.example.demo.hexagonal_architecture.adapter.dto.association.AssociationDTO;
import com.example.demo.hexagonal_architecture.core.service.association.AssociationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/associations-game")
@RequiredArgsConstructor
public class AssociationController {
    private final AssociationService associationService;
    private final AssociationServiceImpl associationServiceImpl;

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

    @GetMapping("/associations/{associationId}")
    public ResponseEntity<AssociationResponse> getAssociationById(@PathVariable Long associationId) {
        Optional<AssociationDTO> associationDTO = associationService.findById(associationId);
        AssociationResponse associationResponse = associationDTO
                .map(AssociationDTO::fromDtoToAssociationResponse)
                .orElse(new AssociationResponse());
        return ResponseEntity.ok(associationResponse);
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

    @GetMapping("/random")
    public ResponseEntity<Long> getRandomAssociationId(){
        Optional<AssociationDTO> associationDTO = associationServiceImpl.findByRandomNumber();
        AssociationResponse associationResponse = associationDTO
                .map(AssociationDTO::fromDtoToAssociationResponse)
                .orElse(new AssociationResponse());
        return ResponseEntity.ok(associationResponse.getId());
    }
}