package com.deusley.calculadora_energia.service;

import com.deusley.calculadora_energia.model.Simulacao;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public double calcularEmergia(Simulacao simulacao) {
        double fatorEnergia = 10.0;
        double fatorMaterial = 5.0;
        double fatorTransporte = 2.0;

        return (simulacao.getConsumoEnergetico() * fatorEnergia)
                + (simulacao.getQuantidadeMaterial() * fatorMaterial)
                + (simulacao.getDistanciaTransporte() * fatorTransporte);
    }

}
