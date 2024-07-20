package com.example.demo.hexagonal_architecture.adapter.in.web.controller;

import com.example.demo.hexagonal_architecture.core.enitity.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.example.demo.hexagonal_architecture.core.service.Security.Jwt.JwtUtils;
import com.example.demo.hexagonal_architecture.core.service.authService.UserDetailsImpl;
import com.example.demo.hexagonal_architecture.adapter.request.LoginRequest;
import com.example.demo.hexagonal_architecture.adapter.request.SignupRequest;
import com.example.demo.hexagonal_architecture.adapter.response.JwtResponse;
import com.example.demo.hexagonal_architecture.adapter.response.MessageResponse;
import com.example.demo.hexagonal_architecture.adapter.dto.UserAuthDTO;
import com.example.demo.hexagonal_architecture.core.port.out.in.UserAuthService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@RestController
@RequestMapping("api/auth/")
public class UserAuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserAuthService userService;
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        try {
            UserAuthDTO userDto = UserAuthDTO.fromRequest(signUpRequest);
            userService.register(userDto);
            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        } catch (DuplicateKeyException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while registering the user");
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername()));
        } catch (Exception e) {
            // Log the error
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserAuth> getUserById(@PathVariable Long userId) {
        Optional<UserAuth> userOptional = userService.findById(userId);
        return userOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
