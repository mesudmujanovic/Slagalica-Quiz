package com.example.demo.hexagonal_architecture.adapter.Mapper;

import com.example.demo.hexagonal_architecture.adapter.Intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.UserDto;
import com.example.demo.hexagonal_architecture.core.Enitity.UserEntity;

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
