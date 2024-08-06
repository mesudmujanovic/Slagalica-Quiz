package com.example.demo.hexagonal_architecture.adapter.in.web.controller.user;

import com.example.demo.hexagonal_architecture.core.enitity.user.UserAuth;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.example.demo.hexagonal_architecture.core.service.Security.Jwt.JwtUtils;
import com.example.demo.hexagonal_architecture.core.service.authService.UserDetailsImpl;
import com.example.demo.hexagonal_architecture.adapter.request.user.LoginRequest;
import com.example.demo.hexagonal_architecture.adapter.request.user.SignupRequest;
import com.example.demo.hexagonal_architecture.adapter.response.user.JwtResponse;
import com.example.demo.hexagonal_architecture.adapter.response.MessageResponse;
import com.example.demo.hexagonal_architecture.adapter.dto.user.UserAuthDTO;
import com.example.demo.hexagonal_architecture.core.port.out.in.user.UserAuthService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import java.util.Optional;

@RestController
@RequestMapping("api/auth/")
public class UserAuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    private final UserAuthService userService;

    public UserAuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UserAuthService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }

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
