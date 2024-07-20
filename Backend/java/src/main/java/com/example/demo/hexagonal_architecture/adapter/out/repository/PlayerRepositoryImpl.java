package com.example.demo.hexagonal_architecture.adapter.out.repository;

import com.example.demo.hexagonal_architecture.core.enitity.PlayerEntity;
import com.example.demo.hexagonal_architecture.core.port.out.PlayerRepository;
import com.example.demo.hexagonal_architecture.core.port.out.persistence.JpaPlayer;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerRepositoryImpl implements PlayerRepository {
    private final JpaPlayer jpaPlayer;
    public PlayerRepositoryImpl(JpaPlayer jpaPlayer) {
        this.jpaPlayer = jpaPlayer;
    }

    @Override
    public PlayerEntity savePlayer(PlayerEntity playerEntity) {
        return jpaPlayer.save(playerEntity);
    }
}
