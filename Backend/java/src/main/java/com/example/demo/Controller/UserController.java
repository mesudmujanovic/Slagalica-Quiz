package com.example.demo.Controller;

import com.example.demo.Service.UserService;
import com.example.demo.infrastucture.Request.UserRequest;
import com.example.demo.infrastucture.Response.UserResponse;
import com.example.demo.infrastucture.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

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
