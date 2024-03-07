package com.example.LogiInsight.repository;

import com.example.LogiInsight.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByCnpj(String cnpj);
}
