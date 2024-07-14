package com.example.demo.hexagonal_architecture.adapter.out.repository;

import com.example.demo.hexagonal_architecture.core.Enitity.UserEntity;
import com.example.demo.hexagonal_architecture.core.port.out.UserRepository;
import com.example.demo.hexagonal_architecture.core.port.out.persistence.JpaUser;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUser jpaUser;

    public UserRepositoryImpl(JpaUser jpaUser) {
        this.jpaUser = jpaUser;
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return jpaUser.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return jpaUser.findAll();
    }
}
