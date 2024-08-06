package com.example.demo.hexagonal_architecture.core.service;

import com.example.demo.hexagonal_architecture.adapter.dto.user.PlayerDTO;
import com.example.demo.hexagonal_architecture.adapter.mapper.PlayerMapper;
import com.example.demo.hexagonal_architecture.adapter.mapperDto.PlayerDTOMapper;
import com.example.demo.hexagonal_architecture.core.enitity.user.PlayerEntity;
import com.example.demo.hexagonal_architecture.core.enitity.user.UserAuth;
import com.example.demo.hexagonal_architecture.core.port.out.PlayerRepository;
import com.example.demo.hexagonal_architecture.core.port.out.in.user.PlayerService;
import com.example.demo.hexagonal_architecture.core.port.out.in.user.UserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerDTOMapper playerDTOMapper;
    private final PlayerMapper playerMapper;
    private final UserAuthService authService;

    @Override
    public PlayerDTO savePlayer(PlayerDTO playerDTO, Long userAuthId) {
        UserAuth userAuth = authService.findById(userAuthId)
                .orElseThrow(() -> new RuntimeException("UserAuth not found"));
        PlayerEntity playerEntity = playerMapper.apply(playerDTO);
        playerEntity.setUser(userAuth);
        PlayerEntity savedEntity = playerRepository.savePlayer(playerEntity);
       return playerDTOMapper.apply(savedEntity);
    }

    @Override
    public PlayerDTO updateFinalScore(Long playerId, int finalScore) {
        PlayerEntity updatedPlayer = playerRepository.updateFinalScore(playerId, finalScore);
        return playerDTOMapper.apply(updatedPlayer);
    }
}
