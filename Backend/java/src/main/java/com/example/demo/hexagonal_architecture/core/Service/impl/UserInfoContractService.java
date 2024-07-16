package com.example.demo.hexagonal_architecture.core.Service.impl;

import com.example.demo.hexagonal_architecture.adapter.dto.UserInfoContactDto;

import java.util.List;

public interface UserInfoContractService {

    public UserInfoContactDto getUserInfo (UserInfoContactDto userInfoContactDto);

    public List<UserInfoContactDto> getAllUsersInfo();

    UserInfoContactDto getById (Long userInfoId);
}