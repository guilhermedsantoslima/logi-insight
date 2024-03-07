package com.example.LogiInsight.rest.controller;

import com.example.LogiInsight.exception.InvalidLoginException;
import com.example.LogiInsight.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginServiceImpl service;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) throws InvalidLoginException {
        String cnpj = loginData.get("cnpj");
        String senha = loginData.get("senha");

        if (service.login(cnpj, senha)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login não autorizado");
        }
    }
}
