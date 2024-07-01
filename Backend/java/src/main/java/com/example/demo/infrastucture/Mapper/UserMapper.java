package com.example.demo.infrastucture.Mapper;

import com.example.demo.Enitity.UserEntity;
import com.example.demo.Intergration.DtoMapper;
import com.example.demo.infrastucture.dto.UserDto;

public enum UserMapper implements DtoMapper<UserEntity, UserDto> {
    INSTANCE;

    @Override
    public UserEntity apply(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setUserscore(userDto.getUserscore());
        return userEntity;
    }
}
