package com.example.demo.hexagonal_architecture.Security.Services;

import com.example.demo.hexagonal_architecture.adapter.out.repository.UserJWTRepository;
import com.example.demo.hexagonal_architecture.core.Enitity.UserAuth;
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