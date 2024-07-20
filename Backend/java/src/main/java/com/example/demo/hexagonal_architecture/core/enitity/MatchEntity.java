package com.example.demo.hexagonal_architecture.core.enitity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Data
@Builder
public class MatchEntity {
    public static List<MatchEntity> matches;

    private List<PlayerEntity> players;

    private List<PlayerEntity> playerEntities;
    private String roomId;
    private Optional<PlayerEntity> winner;
    private int currentGameIndex;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

    public boolean isActive() {
        return this.getCompletedAt().isBefore(LocalDateTime.now());
    }

    public Optional<MatchEntity> findByRoomId(String roomId) {
        return MatchEntity.matches
                .stream()
                .filter(match -> match.getRoomId() == roomId)
                .findAny();
    }

    public Optional<MatchEntity> findActiveByPlayerId(Long playerId) {
        return matches.stream()
                .filter(match -> match.getPlayerEntities().stream()
                        .anyMatch(playerEntity -> playerEntity.getId().equals(playerId)))
                .findFirst();
    }
}
