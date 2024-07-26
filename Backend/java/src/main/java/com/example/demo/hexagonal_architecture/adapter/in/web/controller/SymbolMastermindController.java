package com.example.demo.hexagonal_architecture.adapter.in.web.controller;
import com.example.demo.hexagonal_architecture.core.port.out.in.SymbolMastermindService;
import com.example.demo.hexagonal_architecture.adapter.request.SymbolMastermindRequest;
import com.example.demo.hexagonal_architecture.adapter.response.SymbolMastermindResponse;
import com.example.demo.hexagonal_architecture.adapter.dto.SymbolMastermindDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/symbol-game")
@RequiredArgsConstructor
public class SymbolMastermindController {
    private final SymbolMastermindService symbolMastermindService;

    @PostMapping("/symbol")
    public ResponseEntity<SymbolMastermindResponse> createSymbolMastermind (
             @ModelAttribute SymbolMastermindRequest symbolMastermindRequest,
             @RequestParam("image") MultipartFile multipartFile) {
        SymbolMastermindDTO symbolMastermindDTO = SymbolMastermindDTO.toDto(symbolMastermindRequest);
        SymbolMastermindDTO symbolMastermindDTO1 = symbolMastermindService.createSymbolMastermind(symbolMastermindDTO, multipartFile);
        SymbolMastermindResponse symbolMastermindResponse = SymbolMastermindDTO.toResponse(symbolMastermindDTO1);
        return ResponseEntity.ok(symbolMastermindResponse);
    }

    @GetMapping("/symbols")
    public ResponseEntity<List<SymbolMastermindResponse>> getAllSymbolMastermind() {
        List<SymbolMastermindDTO> symbols = symbolMastermindService.getAllSymbolMastermind();
        List<SymbolMastermindResponse> symbolMastermindResponses = symbols
               .stream()
               .map(symbol -> SymbolMastermindDTO.toResponse(symbol))
               .collect(Collectors.toList());
        return ResponseEntity.ok(symbolMastermindResponses);
    }
}