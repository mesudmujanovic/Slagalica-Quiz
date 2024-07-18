package com.example.demo.hexagonal_architecture.core.enitity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Getter
@Builder
@Setter
public class MatchEntity {
    public static List<MatchEntity> matches;

    private List<Player> players;
    private String roomId;
    private Optional<Player> winner;
    private int currentGameIndex;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

    public boolean isActive() {
        return this.getCompletedAt().isBefore(LocalDateTime.now());
    }

    public Optional<MatchEntity> findByRoomId(String roomId) {
        return MatchEntity.matches
                .stream()
                .filter(a -> a.getRoomId() == roomId)
                .findAny();
    }

    public Optional<MatchEntity> findActiveByPlayerId(Long playerId) {
        return matches.stream()
                .filter(match -> match.getPlayers().stream()
                        .anyMatch(player -> player.getId().equals(playerId)))
                .findFirst();
    }
}
