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
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/letter-words")
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

    @GetMapping
    public ResponseEntity<List<LetterWordResponse>> getLetterWord() {
       List<LetterWordDTO> letterWordDTOList = letterWordServiceImpl.getAll();
       List<LetterWordResponse> letterWordResponse = letterWordDTOList
               .stream()
               .map(lettersWords -> LetterWordDTO.fromDTOToResponse(lettersWords)).collect(Collectors.toList());
       return ResponseEntity.ok(letterWordResponse);
    }

    @GetMapping("/{letterWordId}")
    public ResponseEntity<Optional<LetterWordResponse>> getLetterWordById(@PathVariable Long letterWordId) {
        Optional<LetterWordDTO> letterWordDTOOptional = letterWordServiceImpl.findById(letterWordId);
        Optional<LetterWordResponse> letterWordResponse = letterWordDTOOptional.stream().map(a -> LetterWordDTO.fromDTOToResponse(a)).findFirst();
        return ResponseEntity.ok(letterWordResponse);
    }

    @GetMapping("/random")
    public ResponseEntity<LetterWordResponse> getRandomLetterWord() {
        Optional<LetterWordDTO> letterWordDTOOptional = letterWordServiceImpl.findRandomLetterWordById();
        return letterWordDTOOptional
                .map(dto -> LetterWordDTO.fromDTOToResponse(dto))
                .map(response -> ResponseEntity.ok(response))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}