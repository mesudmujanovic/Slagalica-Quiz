package com.example.demo.hexagonal_architecture.core.service.authService;

import com.example.demo.hexagonal_architecture.adapter.dto.UserAuthDTO;
import com.example.demo.hexagonal_architecture.core.port.out.persistence.UserJWTRepository;
import com.example.demo.hexagonal_architecture.core.enitity.UserAuth;
import com.example.demo.hexagonal_architecture.core.port.out.in.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserAuthImpl implements UserAuthService {
    @Autowired
    private UserJWTRepository userRepository;

    @Autowired
    PasswordEncoder encoder;
        @Override
    public void register(UserAuthDTO userDto) throws Exception {
        UserAuth user = new UserAuth();
        user.setUsername(userDto.getUsername());
        user.setPassword(encoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }
    @Override
    public Optional<UserAuth> findById(Long id) {
        return userRepository.findById(id);
    }
}