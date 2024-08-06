package com.example.demo.hexagonal_architecture.adapter.in.web.controller.user;


import com.example.demo.hexagonal_architecture.adapter.dto.user.PlayerDTO;
import com.example.demo.hexagonal_architecture.adapter.request.user.PlayerRequest;
import com.example.demo.hexagonal_architecture.adapter.response.user.PlayerResponse;
import com.example.demo.hexagonal_architecture.core.port.out.in.user.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/check-player")
@RequiredArgsConstructor
public class PlayerController {

  private final PlayerService playerService;

    @PostMapping("/player")
    public ResponseEntity<PlayerResponse> savePlayer(@RequestBody PlayerRequest playerRequest) {
        PlayerDTO playerDTO = PlayerDTO.fromRequestToDto(playerRequest);
        PlayerDTO savedPlayerDTO = playerService.savePlayer(playerDTO, playerRequest.getUserAuthId());
        PlayerResponse playerResponse = PlayerDTO.fromDtoToResponse(savedPlayerDTO);
        return ResponseEntity.ok(playerResponse);
    }

    @PutMapping("/{playerId}/finalScore")
    public ResponseEntity<PlayerResponse> updateFinalScore(@PathVariable Long playerId,
                                                           @RequestBody PlayerRequest playerRequest) {
        PlayerDTO updatedPlayerDTO = playerService.updateFinalScore(playerId, playerRequest.getTotalScore());
        PlayerResponse playerResponse = PlayerDTO.fromDtoToResponse(updatedPlayerDTO);
        return ResponseEntity.ok(playerResponse);
    }
}