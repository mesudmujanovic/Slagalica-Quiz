package com.example.demo.hexagonal_architecture.core.service;

import com.example.demo.hexagonal_architecture.core.port.out.persistence.UserJWTRepository;
import com.example.demo.hexagonal_architecture.core.enitity.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserJWTRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth user = userRepository.findByUsername(username);
        return UserDetailsImpl.build(user);
    }
}