package com.example.demo.hexagonal_architecture.adapter.in.web.controller;

import com.example.demo.hexagonal_architecture.core.port.in.UserService;
import com.example.demo.hexagonal_architecture.adapter.request.UserRequest;
import com.example.demo.hexagonal_architecture.adapter.response.UserResponse;
import com.example.demo.hexagonal_architecture.adapter.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        UserDto userDto = UserDto.fromRequestToDto(userRequest);
        UserDto saveUser = userService.createUser(userDto);
        return ResponseEntity.ok(saveUser.fromDtoToResponse());
    }

    @GetMapping("allUsers")
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        List<UserDto> userDtoList = userService.getAllUsers();
        return ResponseEntity.ok(userDtoList.stream().map(users -> users.fromDtoToResponse()).collect(Collectors.toList()));
    }

}
