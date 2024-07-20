package com.example.demo.hexagonal_architecture.adapter.in.web.controller;


import com.example.demo.hexagonal_architecture.adapter.dto.PlayerDTO;
import com.example.demo.hexagonal_architecture.adapter.request.PlayerRequest;
import com.example.demo.hexagonal_architecture.adapter.response.PlayerResponse;
import com.example.demo.hexagonal_architecture.core.enitity.PlayerEntity;
import com.example.demo.hexagonal_architecture.core.port.out.in.PlayerService;
import com.example.demo.hexagonal_architecture.core.service.PlayerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assoc")
@RequiredArgsConstructor
public class PlayerController {

  private final PlayerService playerService;

  private final PlayerServiceImpl playerServiceImpl;

    @PostMapping("/savePlayer")
    public ResponseEntity<PlayerResponse> savePlayer(@RequestBody PlayerRequest playerRequest) {
        PlayerDTO playerDTO = PlayerDTO.fromRequestToDto(playerRequest);
        PlayerDTO savedPlayerDTO = playerService.savePlayer(playerDTO, playerRequest.getUserAuthId());
        PlayerResponse playerResponse = PlayerDTO.fromDtoToResponse(savedPlayerDTO);
        return ResponseEntity.ok(playerResponse);
    }
    @PutMapping("/{playerId}/finalScore")
    public ResponseEntity<PlayerResponse> updateFinalScore(
            @PathVariable Long playerId,
            @RequestParam int finalScore) {
        PlayerDTO updatedPlayerDTO = playerService.updateFinalScore(playerId, finalScore);
        if (updatedPlayerDTO != null) {
            PlayerResponse playerResponse = PlayerDTO.fromDtoToResponse(updatedPlayerDTO);
            return ResponseEntity.ok(playerResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
