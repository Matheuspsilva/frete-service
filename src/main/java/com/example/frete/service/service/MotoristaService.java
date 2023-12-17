package com.example.frete.service.service;

import com.example.frete.service.exception.MotoristaNotFoundException;
import com.example.frete.service.model.Motorista;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MotoristaService {

    private final RestTemplate restTemplate;
    private final String motoristaServiceUrl = "http://localhost:8081/motoristas";

    public MotoristaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Motorista get(Long motoristaId) {
        try{
            ResponseEntity<Motorista> response = restTemplate.getForEntity(motoristaServiceUrl + "/" + motoristaId, Motorista.class);
            return response.getBody();
        } catch (Exception e) {
            throw new MotoristaNotFoundException();
        }

    }

}
