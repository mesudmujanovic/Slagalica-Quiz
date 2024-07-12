package com.example.demo.Controller;

import com.example.demo.Service.AssociationService;
import com.example.demo.infrastucture.Request.AssociationRequest;
import com.example.demo.infrastucture.Response.AssociationResponse;
import com.example.demo.infrastucture.dto.AssociationDto;
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