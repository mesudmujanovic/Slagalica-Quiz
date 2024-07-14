package com.example.demo.hexagonal_architecture.adapter.Mapper;

import com.example.demo.hexagonal_architecture.adapter.Intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.UserDto;
import com.example.demo.hexagonal_architecture.core.Enitity.UserEntity;

public enum UserDtoMapper implements DtoMapper<UserDto, UserEntity> {
    INSTANCE;

    @Override
    public UserDto apply(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setUsername(userEntity.getUsername());
        userDto.setUserscore(userEntity.getUserscore());
        return userDto;
    }
}
