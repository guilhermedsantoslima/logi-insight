package com.example.LogiInsight.service.impl;

import com.example.LogiInsight.exception.InvalidLoginException;
import com.example.LogiInsight.model.entity.LoginEntity;
import com.example.LogiInsight.model.entity.UserEntity;
import com.example.LogiInsight.repository.LoginRepository;
import com.example.LogiInsight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoginService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private LoginRepository loginRepository;

    /*
    public boolean login(String cnpj, String senha) throws InvalidLoginException {
        UserEntity user = repository.findByCnpj(cnpj);

        return user != null && user.getSenha().equals(senha);
    }
    */
    public boolean login(String cnpj, String senha) throws InvalidLoginException {
        UserEntity user = repository.findByCnpj(cnpj);

        if (user != null && user.getSenha().equals(senha)) {
            // Adiciona o usuário à tabela de usuários logados
            LoginEntity loggedInUser = new LoginEntity();
            loggedInUser.setUserId(user.getId());
            loggedInUser.setUsername(user.getSobrenome());
            loggedInUser.setLoginTime(LocalDateTime.now());

            loginRepository.save(loggedInUser);

            return true;
        } else {
            throw new InvalidLoginException();
        }
    }

}
