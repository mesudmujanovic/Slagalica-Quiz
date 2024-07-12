package com.example.demo.Controller;
import com.example.demo.Service.SymbolMastermindService;
import com.example.demo.infrastucture.Request.SymbolMastermindRequest;
import com.example.demo.infrastucture.Response.SymbolMastermindResponse;
import com.example.demo.infrastucture.dto.SymbolMastermindDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/assoc")
@CrossOrigin("*")
@RequiredArgsConstructor
public class SymbolMastermindController {
    private final SymbolMastermindService symbolMastermindService;

    @PostMapping("/saveimg")
    public ResponseEntity<SymbolMastermindResponse> createSymbolMastermind(@ModelAttribute SymbolMastermindRequest symbolMastermindRequest,
                                                                           @RequestParam("image") MultipartFile multipartFile) {
        SymbolMastermindDTO symbolMastermindDTO = SymbolMastermindDTO.toDto(symbolMastermindRequest);
        SymbolMastermindDTO symbolMastermindDTO1 = symbolMastermindService.createSymbolMastermind(symbolMastermindDTO, multipartFile);
        SymbolMastermindResponse symbolMastermindResponse = SymbolMastermindDTO.toResponse(symbolMastermindDTO1);
        return ResponseEntity.ok(symbolMastermindResponse);
    }

    @GetMapping("/symbols")
    public ResponseEntity<List<SymbolMastermindResponse>> getAllSymbolMastermind() {
        List<SymbolMastermindDTO> symbols = symbolMastermindService.getAllSymbolMastermind();
        return ResponseEntity.ok(symbols.stream()
                .map(symb -> SymbolMastermindDTO.toResponse(symb))
                .collect(Collectors.toList()));
    }
}