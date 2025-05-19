package com.deusley.calculadora_energia.controller;

import com.deusley.calculadora_energia.model.Simulacao;
import com.deusley.calculadora_energia.service.CalculadoraService;
import com.deusley.calculadora_energia.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/")
public class CalculadoraController {

    @Autowired
    private CalculadoraService calculadoraService;

    @Autowired
    private RelatorioService relatorioService;



    @PostMapping("/calcular")
    public double calcularEmergia(@RequestBody Simulacao simulacao) {
        return calculadoraService.calcularEmergia(simulacao);
    }

    @GetMapping("/introducao")
    public String introducao() {
        return "Emergia é a energia incorporada em recursos materiais e serviços...";
    }

    @PostMapping("/relatorio")
    public ResponseEntity<byte[]> gerarRelatorio(@RequestBody Simulacao simulacao) {
        double resultado = calculadoraService.calcularEmergia(simulacao);
        byte[] pdfBytes = relatorioService.gerarRelatorio(simulacao, resultado);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=relatorio_emergia.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}
