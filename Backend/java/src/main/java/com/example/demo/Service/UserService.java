package com.example.demo.Service;

import com.example.demo.infrastucture.dto.UserDto;

import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto userDto);

    public List<UserDto> getAllUsers();
}
