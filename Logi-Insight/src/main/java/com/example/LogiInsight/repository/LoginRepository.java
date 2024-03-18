package com.example.LogiInsight.repository;

import com.example.LogiInsight.model.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginEntity, Long> {
}
