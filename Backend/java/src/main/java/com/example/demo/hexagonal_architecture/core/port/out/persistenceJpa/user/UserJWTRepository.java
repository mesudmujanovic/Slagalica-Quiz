package com.example.demo.hexagonal_architecture.core.port.out.persistenceJpa.user;

import com.example.demo.hexagonal_architecture.core.enitity.user.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJWTRepository extends JpaRepository<UserAuth, Long> {
    UserAuth findByUsername(String username);
}