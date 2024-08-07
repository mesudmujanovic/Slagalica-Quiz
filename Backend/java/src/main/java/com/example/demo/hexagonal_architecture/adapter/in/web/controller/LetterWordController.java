package com.example.demo.hexagonal_architecture.adapter.in.web.controller;

import com.example.demo.hexagonal_architecture.adapter.dto.LetterWordDTO;
import com.example.demo.hexagonal_architecture.adapter.request.LetterWordRequest;
import com.example.demo.hexagonal_architecture.adapter.response.LetterWordResponse;
import com.example.demo.hexagonal_architecture.core.enitity.LetterWordEntity;
import com.example.demo.hexagonal_architecture.core.service.LetterWordServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/letter-words")
@RequiredArgsConstructor
public class LetterWordController {

    private final LetterWordServiceImpl letterWordServiceImpl;

    @PostMapping
    public ResponseEntity<LetterWordResponse> createLetterWord(@RequestBody LetterWordRequest letterWordRequest) {
        LetterWordDTO letterWordDTO = LetterWordDTO.fromRequestToDTO(letterWordRequest);
        LetterWordDTO letterWordDTO1 = letterWordServiceImpl.saveLetterWord(letterWordDTO);
        LetterWordResponse letterWordResponse = LetterWordDTO.fromDTOToResponse(letterWordDTO1);
        return ResponseEntity.ok(letterWordResponse);
    }

    @GetMapping()
    public ResponseEntity<List<LetterWordResponse>> getLetterWord(@PathVariable Long id) {
       List<LetterWordDTO> letterWordDTOList = letterWordServiceImpl.getAll();
       List<LetterWordResponse> letterWordResponse = letterWordDTOList
               .stream()
               .map(lettersWords -> LetterWordDTO.fromDTOToResponse(lettersWords)).collect(Collectors.toList());
       return ResponseEntity.ok(letterWordResponse);
    }
}