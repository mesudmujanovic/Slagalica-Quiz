package com.example.demo.Service.Impl;

import com.example.demo.Enitity.UserEntity;
import com.example.demo.Repo.UserRepo;
import com.example.demo.Service.UserService;
import com.example.demo.infrastucture.Mapper.UserDtoMapper;
import com.example.demo.infrastucture.Mapper.UserMapper;
import com.example.demo.infrastucture.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = UserMapper.INSTANCE.apply(userDto);
        UserEntity userEntitySave = userRepo.save(userEntity);
        return UserDtoMapper.INSTANCE.apply(userEntitySave);
    }


    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> userList = userRepo.findAll();
        List<UserDto> userDtoList = userList.stream().map(users -> UserDtoMapper.INSTANCE.apply(users)).collect(Collectors.toList());
        userDtoList.sort(UserDto::compareTo);
        return userDtoList;
    }
}
