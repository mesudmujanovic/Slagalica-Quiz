package com.example.demo.hexagonal_architecture.adapter.out.repository;

import com.example.demo.hexagonal_architecture.core.enitity.user.PlayerEntity;
import com.example.demo.hexagonal_architecture.core.port.out.PlayerRepository;
import com.example.demo.hexagonal_architecture.core.port.out.persistenceJpa.user.PlayerJpa;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PlayerRepositoryImpl implements PlayerRepository {
    private final PlayerJpa playerJpa;

    @Override
    public PlayerEntity savePlayer(PlayerEntity playerEntity) {
        return playerJpa.save(playerEntity);
    }

    @Override
    public PlayerEntity findById(Long id) {
        return playerJpa.findById(id).orElse(null);
    }

    @Override
    public PlayerEntity updateFinalScore(Long id, int finalScore) {
        PlayerEntity player = playerJpa.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found with id " + id));
        player.setTotalScore(finalScore);
        return playerJpa.save(player);
    }

}
