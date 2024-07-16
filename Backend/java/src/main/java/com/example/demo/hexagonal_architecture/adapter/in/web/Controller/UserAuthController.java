package com.example.demo.hexagonal_architecture.adapter.in.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.hexagonal_architecture.core.Service.Security.Jwt.JwtUtils;
import com.example.demo.hexagonal_architecture.core.Service.UserDetailsImpl;
import com.example.demo.hexagonal_architecture.adapter.Request.LoginRequest;
import com.example.demo.hexagonal_architecture.adapter.Request.SignupRequest;
import com.example.demo.hexagonal_architecture.adapter.Response.JwtResponse;
import com.example.demo.hexagonal_architecture.adapter.Response.MessageResponse;
import com.example.demo.hexagonal_architecture.adapter.dto.UserAuthDto;
import com.example.demo.hexagonal_architecture.core.port.in.UserAuthService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/auth")
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
            UserAuthDto userDto = UserAuthDto.fromRequest(signUpRequest);
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
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername()));
    }

}
