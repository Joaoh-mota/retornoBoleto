/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joaomota.retornoboleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joaoh
 */
public class LeituraRetornoBancoBrasil implements LeituraRetorno {

    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        try {
            BufferedReader reader =
                    Files.newBufferedReader(Paths.get(nomeArquivo));
            String line;
            List<Boleto> boletos = new ArrayList<>();
            while((line = reader.readLine()) != null){
                String[] vetor = line.split(";");
                Boleto boletoBb = new Boleto();
                
                boletoBb.setId(Integer.parseInt(vetor[0]));
                boletoBb.setCodBanco(vetor[1]);
                boletoBb.setDataVencimento(LocalDate.parse(vetor[2], FORMATO_DATA));
                boletoBb.setDataPagamento(LocalDate.parse(vetor[3], FORMATO_DATA).atTime(0, 0, 0));
                boletoBb.setCpfCliente(vetor[4]);
                boletoBb.setValor(Double.parseDouble(vetor[5]));
                boletoBb.setMulta(Double.parseDouble(vetor[6]));
                boletoBb.setJuros(Double.parseDouble(vetor[7]));
                
                boletos.add(boletoBb);
            }

            return boletos;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
    
}
