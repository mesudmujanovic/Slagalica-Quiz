package com.example.demo.hexagonal_architecture.adapter.dto;

import com.example.demo.hexagonal_architecture.adapter.Request.UserInfoContactRequest;
import com.example.demo.hexagonal_architecture.adapter.Response.UserInfoContactResponse;
import lombok.Data;

@Data
public class UserInfoContactDto {

    private Long id;


    private String name;

    private String lastName;


    private String email;

    private String phone;

    public static UserInfoContactDto reqeustToDto(UserInfoContactRequest infoContactRequest){
        UserInfoContactDto userInfoContactDto = new UserInfoContactDto();
        userInfoContactDto.setEmail(infoContactRequest.getEmail());
        userInfoContactDto.setName(infoContactRequest.getName());
        userInfoContactDto.setPhone(infoContactRequest.getPhone());
        userInfoContactDto.setLastName(infoContactRequest.getLastName());
        return userInfoContactDto;
    };

    public static UserInfoContactResponse dtoToResponse(UserInfoContactDto userDto){
        UserInfoContactResponse response = new UserInfoContactResponse();
        response.setId(userDto.getId());
        response.setEmail(userDto.getEmail());
        response.setPhone(userDto.getPhone());
        response.setLastName(userDto.getLastName());
        response.setName(userDto.getName());
        return response;
    }
}