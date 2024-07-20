package com.example.demo.hexagonal_architecture.adapter.in.web.controller;


import com.example.demo.hexagonal_architecture.adapter.dto.PlayerDTO;
import com.example.demo.hexagonal_architecture.adapter.request.PlayerRequest;
import com.example.demo.hexagonal_architecture.adapter.response.PlayerResponse;
import com.example.demo.hexagonal_architecture.core.port.out.in.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assoc")
@RequiredArgsConstructor
public class PlayerController {

  private final PlayerService playerService;

    @PostMapping("/savePlayer")
    public ResponseEntity<PlayerResponse> savePlayer(@RequestBody PlayerRequest playerRequest) {
        PlayerDTO playerDTO = PlayerDTO.fromRequestToDto(playerRequest);
        PlayerDTO savedPlayerDTO = playerService.savePlayer(playerDTO, playerRequest.getUserAuthId());
        PlayerResponse playerResponse = PlayerDTO.fromDtoToResponse(savedPlayerDTO);
        return ResponseEntity.ok(playerResponse);
    }
}
