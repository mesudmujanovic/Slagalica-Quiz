package com.example.demo.hexagonal_architecture.core.Service;

import com.example.demo.hexagonal_architecture.adapter.dto.UserAuthDto;
import com.example.demo.hexagonal_architecture.core.port.out.persistence.UserJWTRepository;
import com.example.demo.hexagonal_architecture.core.Enitity.UserAuth;
import com.example.demo.hexagonal_architecture.core.port.in.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserAuthImpl implements UserAuthService {
    @Autowired
    private UserJWTRepository userRepository;

    @Autowired
    PasswordEncoder encoder;
        @Override
    public void register(UserAuthDto userDto) throws Exception {
        UserAuth user = new UserAuth();
        user.setUsername(userDto.getUsername());
        user.setPassword(encoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }
}