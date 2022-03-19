
import com.joaomota.retornoboleto.LeituraRetornoBradesco;
import com.joaomota.retornoboleto.ProcessarBoletos;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaoh
 */
public class Principal {
    public static void main(String[] args) {
        final ProcessarBoletos processador = new ProcessarBoletos(new LeituraRetornoBradesco());

        URL url = Principal.class.getClassLoader().getResource("banco-brasil-1.csv");
        Path scriptPath = new File(url.getPath()).toPath();
        String nomeArquivo = scriptPath.toString();
        System.out.println("Arquivo lido " + nomeArquivo + "\n");
        processador.processar(nomeArquivo);
    }
}
