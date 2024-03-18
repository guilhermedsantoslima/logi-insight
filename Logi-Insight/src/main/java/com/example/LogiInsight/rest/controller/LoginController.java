package com.example.LogiInsight.rest.controller;

import com.example.LogiInsight.exception.InvalidLoginException;
import com.example.LogiInsight.service.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
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
