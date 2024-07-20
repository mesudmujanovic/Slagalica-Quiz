package com.example.demo.hexagonal_architecture.core.port.out.in;

import com.example.demo.hexagonal_architecture.adapter.dto.PlayerDTO;

public interface PlayerService {

  PlayerDTO savePlayer(PlayerDTO playerDTO, Long userAuthId);
  PlayerDTO updateTotalScore(Long playerId, int newScore);
  PlayerDTO updateFinalScore(Long playerId, int finalScore);

}
