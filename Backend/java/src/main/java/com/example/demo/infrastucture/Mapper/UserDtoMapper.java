package com.example.demo.infrastucture.Mapper;

import com.example.demo.Enitity.UserEntity;
import com.example.demo.Intergration.DtoMapper;
import com.example.demo.infrastucture.dto.UserDto;

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
