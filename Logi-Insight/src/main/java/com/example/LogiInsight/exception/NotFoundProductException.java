package com.example.LogiInsight.exception;

public class NotFoundProductException extends Exception{

    public NotFoundProductException() {
        super("Produto não encontrado");
    }
}
