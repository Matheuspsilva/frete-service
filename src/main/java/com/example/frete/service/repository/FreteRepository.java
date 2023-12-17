package com.example.frete.service.repository;

import com.example.frete.service.model.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long> {

}
