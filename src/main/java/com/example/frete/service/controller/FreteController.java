package com.example.frete.service.controller;

import com.example.frete.service.exception.MotoristaNotFoundException;
import com.example.frete.service.model.Frete;
import com.example.frete.service.model.Motorista;
import com.example.frete.service.payload.response.FreteResponsePayload;
import com.example.frete.service.service.FreteService;
import com.example.frete.service.service.MotoristaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/fretes")
@RestController
public class FreteController {
    private static final Logger log = LoggerFactory.getLogger(MotoristaService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FreteService freteService;

    @Autowired
    private MotoristaService motoristaService;

//    @GetMapping("/fretes")
//    public ResponseEntity<List<Frete>> getAll() {
//        return ResponseEntity.ok(freteService.getAll());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<FreteResponsePayload> get(@PathVariable Long id) {
        Frete frete = freteService.get(id);

        // Criação do cabeçalho HTTP com serviceName
        HttpHeaders headers = new HttpHeaders();
        headers.set("serviceName", "frete-service");

        // Criação de HttpEntity para incluir cabeçalhos
        HttpEntity<String> entity = new HttpEntity<>(headers);


        // Buscar motorista em motorista-service com os cabeçalhos
        // ResponseEntity<Motorista> motorista = restTemplate.getForEntity("http://localhost:8081/motoristas/" + frete.getIdMotorista(), Motorista.class);
        ResponseEntity<Motorista> motorista = restTemplate.exchange(
                "http://motorista-service:8081/motoristas/" + frete.getIdMotorista(),
                HttpMethod.GET,
                entity,
                Motorista.class);

        // Criar payload de resposta
        FreteResponsePayload freteResponsePayload = new FreteResponsePayload();
        freteResponsePayload.setOrigem(frete.getOrigem());
        freteResponsePayload.setDestino(frete.getDestino());
        freteResponsePayload.setMotorista(motorista.getBody());

        return ResponseEntity.ok(freteResponsePayload);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Frete frete) {
        try {
            return ResponseEntity.ok(freteService.create(frete));
        } catch (MotoristaNotFoundException erro) {
            //Retornar mensagem do erro de motorista não encontrado
            return ResponseEntity.badRequest().body(erro.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
