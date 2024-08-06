package com.example.demo.hexagonal_architecture.adapter.mapperDto;

import com.example.demo.hexagonal_architecture.adapter.dto.user.PlayerDTO;
import com.example.demo.hexagonal_architecture.adapter.intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.core.enitity.user.PlayerEntity;
import org.springframework.stereotype.Component;

@Component
public class PlayerDTOMapper implements DtoMapper<PlayerDTO, PlayerEntity> {

    @Override
    public PlayerDTO apply(PlayerEntity playerEntity) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(playerEntity.getId());
        playerDTO.setUserAuthId(playerEntity.getUser().getId());
        playerDTO.setTotalScore(playerEntity.getTotalScore());
        return playerDTO;
    }
}
