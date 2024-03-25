package com.example.LogiInsight.exception;

public class CnpjAlreadyExistsException extends Exception{
    public CnpjAlreadyExistsException() {
        super("Esse cnpj já existe");
    }
}
