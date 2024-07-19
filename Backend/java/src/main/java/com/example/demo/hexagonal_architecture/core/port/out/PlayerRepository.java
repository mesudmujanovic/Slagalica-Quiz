package com.example.demo.hexagonal_architecture.core.port.out;
import com.example.demo.hexagonal_architecture.core.enitity.PlayerEntity;

public interface PlayerRepository {

    PlayerEntity savePlayer(PlayerEntity playerEntity);
}
