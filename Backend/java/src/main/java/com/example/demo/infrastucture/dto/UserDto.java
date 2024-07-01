package com.example.demo.infrastucture.dto;

import com.example.demo.infrastucture.Request.UserRequest;
import com.example.demo.infrastucture.Response.UserResponse;
import lombok.Data;

@Data
public class UserDto implements Comparable<UserDto>{
    private Long id;

    private int userscore;
    private String username;


    public static UserDto fromRequestToDto(UserRequest userRequest){
        UserDto userDto = new UserDto();
        userDto.setUsername(userRequest.getUsername());
        userDto.setUserscore(userRequest.getUserscore());
        return userDto;
    };

    public UserResponse fromDtoToResponse(){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(this.getId());
        userResponse.setUsername(this.getUsername());
        userResponse.setUserscore(this.getUserscore());
        return userResponse;
    }

    @Override
    public int compareTo(UserDto other) {
        return Integer.compare(other.getUserscore(), this.getUserscore());

    }
}
