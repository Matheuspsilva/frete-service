package com.example.frete.service.controller;

import com.example.frete.service.exception.MotoristaNotFoundException;
import com.example.frete.service.model.Frete;
import com.example.frete.service.payload.response.FreteResponsePayload;
import com.example.frete.service.service.FreteService;
import com.example.frete.service.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class FreteController {

    @Autowired
    private FreteService freteService;

    @Autowired
    private MotoristaService motoristaService;

//    @GetMapping("/fretes")
//    public ResponseEntity<List<Frete>> getAll() {
//        return ResponseEntity.ok(freteService.getAll());
//    }

    @GetMapping("/fretes/{id}")
    public ResponseEntity<FreteResponsePayload> get(@PathVariable Long id) {
        Frete frete = freteService.get(id);
        // Buscar motorista em motorista-service
        FreteResponsePayload freteResponsePayload = new FreteResponsePayload();
        freteResponsePayload.setOrigem(frete.getOrigem());
        freteResponsePayload.setDestino(frete.getDestino());
        freteResponsePayload.setMotorista(motoristaService.get(frete.getIdMotorista()));

        return ResponseEntity.ok(freteResponsePayload);
    }

    @PostMapping("/fretes")
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
