package com.example.demo.hexagonal_architecture.adapter.in.web.Controller;

import com.example.demo.hexagonal_architecture.core.port.in.AssociationService;
import com.example.demo.hexagonal_architecture.adapter.Request.AssociationRequest;
import com.example.demo.hexagonal_architecture.adapter.Response.AssociationResponse;
import com.example.demo.hexagonal_architecture.adapter.dto.AssociationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/assoc")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AssociationController {

    private final AssociationService associationService;

    @PostMapping("/save")
    public ResponseEntity<AssociationResponse> saveAssociation(@RequestBody AssociationRequest associationRequest) {
        AssociationDto associationDto = AssociationDto.fromRequestToDto(associationRequest);
        AssociationDto associationDtoSave = associationService.saveAssociation(associationDto);
        return ResponseEntity.ok(associationDtoSave.fromDtoToAssociationResponse());
    }

    @GetMapping("/all")
    public ResponseEntity<List<AssociationResponse>> getAll() {
        List<AssociationDto> associationDtos = associationService.getAll();
        return ResponseEntity.ok(associationDtos.stream()
                .map(AssociationDto::fromDtoToAssociationResponse)
                .collect(Collectors.toList()));
    }
}