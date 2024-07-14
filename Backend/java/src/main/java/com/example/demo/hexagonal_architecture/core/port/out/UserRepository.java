package com.example.demo.hexagonal_architecture.core.port.out;

import com.example.demo.hexagonal_architecture.core.Enitity.UserEntity;

import java.util.List;

public interface UserRepository {

    public UserEntity createUser(UserEntity userEntity);

    public List<UserEntity> getAllUsers();
}
