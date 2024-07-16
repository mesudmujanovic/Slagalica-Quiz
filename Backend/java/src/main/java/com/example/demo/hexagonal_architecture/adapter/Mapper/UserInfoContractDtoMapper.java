package com.example.demo.hexagonal_architecture.adapter.Mapper;

import com.example.demo.hexagonal_architecture.adapter.Intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.UserInfoContactDto;
import com.example.demo.hexagonal_architecture.core.Enitity.UserInfoContact;

public enum UserInfoContractDtoMapper implements DtoMapper<UserInfoContactDto, UserInfoContact> {
    INSTANCE;

    @Override
    public UserInfoContactDto apply(UserInfoContact userInfoContact) {
        UserInfoContactDto userInfoContactDto = new UserInfoContactDto();
        userInfoContactDto.setId(userInfoContact.getId());
        userInfoContactDto.setName(userInfoContact.getName());
        userInfoContactDto.setLastName(userInfoContact.getLastName());
        userInfoContactDto.setPhone(userInfoContact.getPhone());
        userInfoContactDto.setEmail(userInfoContact.getEmail());
        return userInfoContactDto;
    }
}
