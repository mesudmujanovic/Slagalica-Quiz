package com.example.demo.hexagonal_architecture.adapter.in.web.Controller;

import com.example.demo.hexagonal_architecture.adapter.Request.UserInfoContactRequest;
import com.example.demo.hexagonal_architecture.adapter.Response.UserInfoContactResponse;
import com.example.demo.hexagonal_architecture.adapter.dto.UserInfoContactDto;
import com.example.demo.hexagonal_architecture.core.Service.impl.UserInfoContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")

public class UserInfoController {

    @Autowired
    UserInfoContractService userInfoContractService;

    @PostMapping("/usersInfo")
    public ResponseEntity<UserInfoContactResponse> saveInfo(@RequestBody UserInfoContactRequest userInfoContactRequest){
        UserInfoContactDto userInfoContactDto = UserInfoContactDto.reqeustToDto(userInfoContactRequest);
        UserInfoContactDto userInfoContactDtoSave = userInfoContractService.getUserInfo(userInfoContactDto);
        return ResponseEntity.ok(UserInfoContactDto.dtoToResponse(userInfoContactDtoSave));
    }

    @GetMapping("/getAllInfo")
    public ResponseEntity<List<UserInfoContactResponse>> getAllInfo(){
        List<UserInfoContactDto> userInfoContactList = userInfoContractService.getAllUsersInfo();
        return ResponseEntity.ok( userInfoContactList.stream().map(UserInfoContactDto::dtoToResponse).collect(Collectors.toList()));
    }

    @GetMapping("/getById/{userInfoId}")
    public ResponseEntity<UserInfoContactResponse> getById( @PathVariable Long userInfoId ){
        UserInfoContactDto userInfoContactDto = userInfoContractService.getById(userInfoId);
        return ResponseEntity.ok( UserInfoContactDto.dtoToResponse(userInfoContactDto) );
    }
}