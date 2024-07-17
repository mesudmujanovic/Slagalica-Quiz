package com.example.demo.hexagonal_architecture.adapter.dto;

import com.example.demo.hexagonal_architecture.adapter.request.SignupRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuthDto {

    private Long id;
    private String username;

    private String password;

    public static UserAuthDto fromRequest(SignupRequest request){
        UserAuthDto userDTO = new UserAuthDto();
        userDTO.setUsername(request.getUsername());
        userDTO.setPassword(request.getPassword());
        return userDTO;
    }
}
