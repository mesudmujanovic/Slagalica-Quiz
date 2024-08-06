package com.example.demo.hexagonal_architecture.core.port.out.in.user;

import com.example.demo.hexagonal_architecture.adapter.dto.user.UserAuthDTO;
import com.example.demo.hexagonal_architecture.core.enitity.user.UserAuth;

import java.util.Optional;

public interface UserAuthService {
    void register(UserAuthDTO userDTO) throws Exception;
    Optional<UserAuth> findById(Long id);
}
