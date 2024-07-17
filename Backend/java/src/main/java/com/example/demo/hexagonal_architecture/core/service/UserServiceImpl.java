package com.example.demo.hexagonal_architecture.core.service;

import com.example.demo.hexagonal_architecture.core.enitity.UserEntity;
import com.example.demo.hexagonal_architecture.core.port.out.UserRepository;
import com.example.demo.hexagonal_architecture.core.port.in.UserService;
import com.example.demo.hexagonal_architecture.adapter.mapperDto.UserDtoMapper;
import com.example.demo.hexagonal_architecture.adapter.mapper.UserMapper;
import com.example.demo.hexagonal_architecture.adapter.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

   private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = UserMapper.INSTANCE.apply(userDto);
        UserEntity userEntitySave = userRepository.createUser(userEntity);
        return UserDtoMapper.INSTANCE.apply(userEntitySave);
    }
    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> userList = userRepository.getAllUsers();
        List<UserDto> userDtoList = userList.stream().map(users -> UserDtoMapper.INSTANCE.apply(users)).collect(Collectors.toList());
        userDtoList.sort(UserDto::compareTo);
        return userDtoList;
    }
}
