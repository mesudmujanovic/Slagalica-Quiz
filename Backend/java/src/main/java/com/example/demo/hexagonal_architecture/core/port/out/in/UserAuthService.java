package com.example.demo.hexagonal_architecture.core.port.out.in;

import com.example.demo.hexagonal_architecture.adapter.dto.UserAuthDto;
import com.example.demo.hexagonal_architecture.core.enitity.UserAuth;

import java.util.Optional;

public interface UserAuthService {
    public  void register(UserAuthDto userDTO) throws Exception;

    Optional<UserAuth> findById(Long id);
}
