package com.deusley.calculadora_energia.service;

import com.deusley.calculadora_energia.model.Simulacao;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class RelatorioService {

    public byte[] gerarRelatorio(Simulacao simulacao, double resultado) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, baos);
            document.open();

            document.add(new Paragraph("Relatório de Simulação de Emergia"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Consumo Energético: " + simulacao.getConsumoEnergetico() + " kWh"));
            document.add(new Paragraph("Quantidade de Material: " + simulacao.getQuantidadeMaterial() + " kg"));
            document.add(new Paragraph("Distância de Transporte: " + simulacao.getDistanciaTransporte() + " km"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Resultado do Cálculo de Emergia: " + resultado + " unidades"));

            document.close();

            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;


        }
    }
}