package com.example.demo.hexagonal_architecture.core.port.out.in.user;

import com.example.demo.hexagonal_architecture.adapter.dto.user.PlayerDTO;

public interface PlayerService {

  PlayerDTO savePlayer(PlayerDTO playerDTO, Long userAuthId);
  PlayerDTO updateFinalScore(Long playerId, int finalScore);
}
