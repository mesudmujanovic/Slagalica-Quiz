package com.example.demo.hexagonal_architecture.core.port.out.persistence;

import com.example.demo.hexagonal_architecture.core.Enitity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUser extends JpaRepository<UserEntity, Long> {
}
