package com.example.demo.hexagonal_architecture.adapter.mapper;

import com.example.demo.hexagonal_architecture.adapter.dto.user.PlayerDTO;
import com.example.demo.hexagonal_architecture.adapter.intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.core.enitity.user.PlayerEntity;
import com.example.demo.hexagonal_architecture.core.enitity.user.UserAuth;
import com.example.demo.hexagonal_architecture.core.port.out.persistenceJpa.user.UserJWTRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class PlayerMapper implements DtoMapper<PlayerEntity, PlayerDTO> {
    private final UserJWTRepository userJWTRepository;
    public PlayerMapper(UserJWTRepository userJWTRepository) {
        this.userJWTRepository = userJWTRepository;
    }

    @Override
    public PlayerEntity apply(PlayerDTO playerDTO) {
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setId(playerDTO.getId());
        Long userId = playerDTO.getUserAuthId();
        Optional<UserAuth> userAuthOptional = userJWTRepository.findById(userId);
        if (userAuthOptional.isPresent()) {
            playerEntity.setUser(userAuthOptional.get());
        } else {
            throw new RuntimeException("UserAuth not found for ID: " + userId);
        }
        return  playerEntity;
    }
}
