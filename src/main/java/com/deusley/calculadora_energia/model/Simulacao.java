package com.deusley.calculadora_energia.model;


public class Simulacao {

    private Double consumoEnergetico;
    private Double quantidadeMaterial;
    private Double distanciaTransporte;


    public Double getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(Double consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public Double getQuantidadeMaterial() {
        return quantidadeMaterial;
    }

    public void setQuantidadeMaterial(Double quantidadeMaterial) {
        this.quantidadeMaterial = quantidadeMaterial;
    }

    public Double getDistanciaTransporte() {
        return distanciaTransporte;
    }

    public void setDistanciaTransporte(Double distanciaTransporte) {
        this.distanciaTransporte = distanciaTransporte;
    }
}
