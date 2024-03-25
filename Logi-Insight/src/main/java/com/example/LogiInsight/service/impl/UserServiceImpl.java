package com.example.LogiInsight.service.impl;

import com.example.LogiInsight.exception.CnpjAlreadyExistsException;
import com.example.LogiInsight.exception.NotFoundUserException;
import com.example.LogiInsight.model.dto.UserDTO;
import com.example.LogiInsight.model.entity.UserEntity;
import com.example.LogiInsight.repository.UserRepository;
import com.example.LogiInsight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Override
    public UserDTO saveUser(UserDTO userDTO)throws CnpjAlreadyExistsException {
        UserEntity userCnpj = repository.findByCnpj(userDTO.getCnpj());
        if (userCnpj != null) {
            throw new CnpjAlreadyExistsException();
        }

        UserEntity existingUserByPassword = repository.findBySenha(userDTO.getSenha());
        if (existingUserByPassword != null) {
            throw new RuntimeException("Essa senha já existe");
        }
        UserEntity user = new UserEntity();

        user.setNome(userDTO.getNome());
        user.setSobrenome(userDTO.getSobrenome());
        user.setCnpj(userDTO.getCnpj());
        user.setSenha(userDTO.getSenha());

        repository.save(user);

        return userDTO;
    }

    @Override
    public List<UserDTO> listAll() {
        List<UserEntity> userEntities = repository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();

        userEntities.forEach(userEntity -> {
            UserDTO userDTO = new UserDTO();

            userDTO.setNome(userEntity.getNome());
            userDTO.setSobrenome(userEntity.getSobrenome());
            userDTO.setCnpj(userEntity.getCnpj());
            userDTO.setSenha(userEntity.getSenha());

            userDTOS.add(userDTO);
        });

        return userDTOS;
    }

    @Override
    public Optional<UserEntity> getById(Long id)throws NotFoundUserException {
        Optional<UserEntity> userEntities = repository.findById(id);

        if(!userEntities.isPresent()){
           throw new NotFoundUserException();
        }
        return repository.findById(id);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
