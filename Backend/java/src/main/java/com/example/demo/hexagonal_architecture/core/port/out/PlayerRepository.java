package com.example.demo.hexagonal_architecture.core.port.out;
import com.example.demo.hexagonal_architecture.core.enitity.user.PlayerEntity;

public interface PlayerRepository {

    PlayerEntity savePlayer(PlayerEntity playerEntity);
    PlayerEntity findById(Long id);
    PlayerEntity updateFinalScore(Long id, int finalScore);

}
