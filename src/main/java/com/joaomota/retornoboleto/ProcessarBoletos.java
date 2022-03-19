/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joaomota.retornoboleto;

import java.util.List;

/**
 *
 * @author joaoh
 */
public class ProcessarBoletos {
private LeituraRetorno leituraRetorno;

    public ProcessarBoletos(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }

    public final void processar(String nomeArquivo) {
        System.out.println("Boletos");
        System.out.println("########################");
        List<Boleto> boletos = leituraRetorno.lerArquivo(nomeArquivo);
        boletos.forEach(System.out::println);
    }

    public void setLeituraRetorno(LeituraRetorno leituraRetorno) {
        this.leituraRetorno = leituraRetorno;
    }
}
