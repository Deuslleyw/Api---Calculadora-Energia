package com.deusley.calculadora_energia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_Simulacoes")
public class Simulacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Double consumoEnergia;
    private Double quantidadeEnergia;
    private Double distanciaEnergia;


}
