package com.example.LogiInsight.service.impl;

import com.example.LogiInsight.exception.InvalidLoginException;
import com.example.LogiInsight.model.entity.UserEntity;
import com.example.LogiInsight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl {
    @Autowired
    private UserRepository repository;

    public boolean login(String cnpj, String senha) throws InvalidLoginException {
        UserEntity user = repository.findByCnpj(cnpj);

        return user != null && user.getSenha().equals(senha);
    }
}
