package com.pblgllgs.user.controller;

import com.pblgllgs.user.entity.UserModel;
import com.pblgllgs.user.dto.UserRecordDto;
import com.pblgllgs.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("users")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserRecordDto userRecordDto){
        return new ResponseEntity<>(userService.save(userRecordDto),HttpStatus.CREATED);
    }
}
