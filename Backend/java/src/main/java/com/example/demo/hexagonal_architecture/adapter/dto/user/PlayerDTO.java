package com.example.demo.hexagonal_architecture.adapter.dto.user;

import com.example.demo.hexagonal_architecture.adapter.request.user.PlayerRequest;
import com.example.demo.hexagonal_architecture.adapter.response.user.PlayerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

    private Long id;
    private Long userAuthId;
    private int totalScore;

    public static PlayerDTO fromRequestToDto(PlayerRequest playerRequest) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(playerRequest.getId());
        playerDTO.setTotalScore(playerRequest.getTotalScore());
        playerDTO.setUserAuthId(playerRequest.getUserAuthId());
        return  playerDTO;
    }

    public static PlayerResponse fromDtoToResponse (PlayerDTO playerDTO) {
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setId(playerDTO.getId());
        playerResponse.setUserId(playerDTO.getUserAuthId());
        playerResponse.setTotalScore(playerDTO.getTotalScore());
        return  playerResponse;
    }
}
