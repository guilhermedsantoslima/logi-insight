package com.example.LogiInsight.exception;

public class NotFoundUserException extends Exception{
    public NotFoundUserException() {
        super("Usuário não encontrado");
    }
}
