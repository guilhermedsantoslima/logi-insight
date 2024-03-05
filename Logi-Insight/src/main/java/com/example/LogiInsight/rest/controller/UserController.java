package com.example.LogiInsight.rest.controller;

import com.example.LogiInsight.model.dto.UserDTO;
import com.example.LogiInsight.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    private UserService service;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO save(@RequestBody @Valid UserDTO userDTO){
        return service.saveUser(userDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAll(){
        return service.listAll();
    }
}
