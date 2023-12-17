package com.example.frete.service.payload.response;

import com.example.frete.service.model.Frete;
import com.example.frete.service.model.Motorista;

public class FreteResponsePayload {

    private String origem;

    private String destino;

    private Motorista motorista;

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
}
