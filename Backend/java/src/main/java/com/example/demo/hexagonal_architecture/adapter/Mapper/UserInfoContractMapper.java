package com.example.demo.hexagonal_architecture.adapter.Mapper;

import com.example.demo.hexagonal_architecture.adapter.Intergration.DtoMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.UserInfoContactDto;
import com.example.demo.hexagonal_architecture.core.Enitity.UserInfoContact;

public enum UserInfoContractMapper implements DtoMapper<UserInfoContact, UserInfoContactDto> {
    INSTANCE;

    @Override
    public UserInfoContact apply(UserInfoContactDto userInfoContactDto) {
        UserInfoContact userInfoContact = new UserInfoContact();
        userInfoContact.setId(userInfoContactDto.getId());
        userInfoContact.setName(userInfoContactDto.getName());
        userInfoContact.setPhone(userInfoContactDto.getPhone());
        userInfoContact.setEmail(userInfoContactDto.getEmail());
        userInfoContact.setLastName(userInfoContactDto.getLastName());
        return userInfoContact;
    }
}
