package com.example.LogiInsight.service;

import com.example.LogiInsight.exception.CnpjAlreadyExistsException;
import com.example.LogiInsight.exception.NotFoundUserException;
import com.example.LogiInsight.model.dto.UserDTO;
import com.example.LogiInsight.model.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO saveUser(UserDTO userDTO)throws CnpjAlreadyExistsException;
    List<UserDTO> listAll();
    Optional<UserEntity> getById(Long id) throws NotFoundUserException;

    void delete(Long id);

}
