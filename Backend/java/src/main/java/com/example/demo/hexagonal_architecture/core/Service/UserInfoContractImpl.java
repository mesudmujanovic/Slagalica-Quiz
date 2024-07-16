package com.example.demo.hexagonal_architecture.core.Service;

import com.example.demo.hexagonal_architecture.adapter.Mapper.UserInfoContractDtoMapper;
import com.example.demo.hexagonal_architecture.adapter.Mapper.UserInfoContractMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.UserInfoContactDto;
import com.example.demo.hexagonal_architecture.adapter.out.repository.UserInfoContactRepository;
import com.example.demo.hexagonal_architecture.core.Enitity.UserInfoContact;
import com.example.demo.hexagonal_architecture.core.Service.impl.UserInfoContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class UserInfoContractImpl implements UserInfoContractService {

    @Autowired
    UserInfoContactRepository userInfoContactRepository;

    @Override
    @Validated
    public UserInfoContactDto getUserInfo(UserInfoContactDto userInfoContactDto) {
        UserInfoContact userInfoContact = UserInfoContractMapper.INSTANCE.apply(userInfoContactDto);
        UserInfoContact saveUserInfo = userInfoContactRepository.save(userInfoContact);
        return UserInfoContractDtoMapper.INSTANCE.apply(saveUserInfo);
    }

    @Override
    public List<UserInfoContactDto> getAllUsersInfo() {
        List<UserInfoContact> listsUsersInfo = userInfoContactRepository.findAll();
        return listsUsersInfo.stream().map( users -> UserInfoContractDtoMapper.INSTANCE.apply(users)).collect(Collectors.toList());
    }

    @Override
    public UserInfoContactDto getById(Long userInfoId) {
        UserInfoContact userInfoContact = userInfoContactRepository.findById(userInfoId).orElse(null);
        return UserInfoContractDtoMapper.INSTANCE.apply(userInfoContact);
    }
}