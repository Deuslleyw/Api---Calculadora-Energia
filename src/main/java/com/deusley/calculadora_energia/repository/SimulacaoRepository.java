package com.deusley.calculadora_energia.repository;

import com.deusley.calculadora_energia.model.Simulacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SimulacaoRepository extends JpaRepository<Simulacao, UUID> {
}
