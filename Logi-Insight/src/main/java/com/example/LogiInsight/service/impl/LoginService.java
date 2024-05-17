package com.example.LogiInsight.service.impl;

import com.example.LogiInsight.exception.InvalidLoginException;
import com.example.LogiInsight.exception.NotFoundUserException;
import com.example.LogiInsight.model.dto.UserDTO;
import com.example.LogiInsight.model.entity.LoginEntity;
import com.example.LogiInsight.model.entity.UserEntity;
import com.example.LogiInsight.repository.LoginRepository;
import com.example.LogiInsight.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private LoginRepository loginRepository;

    public boolean login(String cnpj, String senha) throws InvalidLoginException {
        UserEntity user = repository.findByCnpj(cnpj);

        if (user != null && user.getSenha().equals(senha)) {
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

    public List<LoginEntity> listAll() {
        List<LoginEntity> loginEntities = loginRepository.findAll();
        return loginEntities;
    }

    public Optional<LoginEntity> getById(Long id)throws NotFoundUserException {
        Optional<LoginEntity> loginEntities = loginRepository.findById(id);

        if(!loginEntities.isPresent()){
            throw new NotFoundUserException();
        }
        return loginRepository.findById(id);
    }
}
