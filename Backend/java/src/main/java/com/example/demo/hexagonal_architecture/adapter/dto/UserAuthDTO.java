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
public class UserAuthDTO {

    private Long id;
    private String username;
    private String password;

    public static UserAuthDTO fromRequest(SignupRequest request){
        UserAuthDTO userDTO = new UserAuthDTO();
        userDTO.setUsername(request.getUsername());
        userDTO.setPassword(request.getPassword());
        return userDTO;
    }
}
