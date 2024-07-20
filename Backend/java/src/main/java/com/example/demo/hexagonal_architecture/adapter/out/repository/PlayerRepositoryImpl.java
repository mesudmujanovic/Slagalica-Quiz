package com.example.demo.hexagonal_architecture.adapter.out.repository;

import com.example.demo.hexagonal_architecture.core.enitity.PlayerEntity;
import com.example.demo.hexagonal_architecture.core.port.out.PlayerRepository;
import com.example.demo.hexagonal_architecture.core.port.out.persistence.JpaPlayer;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PlayerRepositoryImpl implements PlayerRepository {
    private final JpaPlayer jpaPlayer;

    @Override
    public PlayerEntity savePlayer(PlayerEntity playerEntity) {
        return jpaPlayer.save(playerEntity);
    }

    @Override
    public PlayerEntity findById(Long id) {
        return jpaPlayer.findById(id).orElse(null);
    }

    @Override
    public PlayerEntity updateFinalScore(Long id, int finalScore) {
        PlayerEntity player = jpaPlayer.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Player not found with id " + id));
        player.setTotalScore(finalScore);
        return jpaPlayer.save(player);
    }

}
