package com.example.LogiInsight.service.impl;

import com.example.LogiInsight.model.dto.UserDTO;
import com.example.LogiInsight.model.entity.UserEntity;
import com.example.LogiInsight.repository.UserRepository;
import com.example.LogiInsight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        UserEntity user = new UserEntity();

        user.setNome(userDTO.getNome());
        user.setSobrenome(userDTO.getSobrenome());
        user.setCnpj(userDTO.getCnpj());
        user.setSenha(userDTO.getSenha());

        repository.save(user);

        return userDTO;
    }
}
