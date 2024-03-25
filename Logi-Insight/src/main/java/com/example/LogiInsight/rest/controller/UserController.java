package com.example.LogiInsight.rest.controller;

import com.example.LogiInsight.exception.CnpjAlreadyExistsException;
import com.example.LogiInsight.exception.NotFoundUserException;
import com.example.LogiInsight.model.dto.UserDTO;
import com.example.LogiInsight.model.entity.UserEntity;
import com.example.LogiInsight.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    private UserService service;
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO save(@RequestBody @Valid UserDTO userDTO) throws CnpjAlreadyExistsException {
        return service.saveUser(userDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAll(){
        return service.listAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<UserEntity> getUserById(@PathVariable("id") Long id) throws NotFoundUserException {
        return service.getById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id){
        service.delete(id);
    }
}
