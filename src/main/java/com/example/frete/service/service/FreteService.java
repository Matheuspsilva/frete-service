package com.example.frete.service.service;

import com.example.frete.service.exception.MotoristaNotFoundException;
import com.example.frete.service.model.Frete;
import com.example.frete.service.model.Motorista;
import com.example.frete.service.repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreteService {

    @Autowired
    private FreteRepository freteRepository;

    @Autowired
    private MotoristaService motoristaService;

    public Frete create(Frete frete) {
        //Verificar se motorista existe em motorista-service
        motoristaService.get(frete.getIdMotorista());

        return freteRepository.save(frete);
    }

    public Frete get(Long id) {
        return freteRepository.findById(id).orElseThrow(() -> new RuntimeException("Frete não encontrado"));
    }

}
