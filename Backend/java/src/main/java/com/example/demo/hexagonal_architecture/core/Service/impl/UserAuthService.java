package com.example.demo.hexagonal_architecture.core.Service.impl;

import com.example.demo.hexagonal_architecture.adapter.dto.UserAuthDto;

public interface UserAuthService {
    public  void register(UserAuthDto userDTO) throws Exception;

}
