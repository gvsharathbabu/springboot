package com.training.springboot.controller;

import com.training.springboot.dto.User;
import com.training.springboot.service.UserValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserValidation userValidation;

    @PostMapping("/register")
    public ResponseEntity<String> addStudent(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userValidation.validateUser(user), HttpStatus.OK);
    }


}
