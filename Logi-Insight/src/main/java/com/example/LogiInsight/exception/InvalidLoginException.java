package com.example.LogiInsight.exception;

public class InvalidLoginException extends Exception{
    public InvalidLoginException() {
        super("Login inválido");
    }
}
