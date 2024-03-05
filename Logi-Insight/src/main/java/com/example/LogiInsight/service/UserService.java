package com.example.LogiInsight.service;

import com.example.LogiInsight.model.dto.UserDTO;

import java.util.List;

public interface UserService {

    public UserDTO saveUser(UserDTO userDTO);
    public List<UserDTO> listAll();
}
