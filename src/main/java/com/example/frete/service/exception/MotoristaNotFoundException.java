package com.example.frete.service.exception;

public class MotoristaNotFoundException extends RuntimeException{
    public MotoristaNotFoundException() {
        super("Motorista não encontrado");
    }
}
