package com.example.demo.hexagonal_architecture.core.port.out.in;

import com.example.demo.hexagonal_architecture.adapter.dto.UserAuthDTO;
import com.example.demo.hexagonal_architecture.core.enitity.UserAuth;

import java.util.Optional;

public interface UserAuthService {
    void register(UserAuthDTO userDTO) throws Exception;
    Optional<UserAuth> findById(Long id);
}
