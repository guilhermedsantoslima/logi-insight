package com.example.LogiInsight.controller;

import com.example.LogiInsight.model.dto.UserDTO;
import com.example.LogiInsight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO save(@RequestBody UserDTO userDTO){
        return service.saveUser(userDTO);
    }
}
