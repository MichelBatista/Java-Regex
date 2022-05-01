package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validarEndereço {
    public static void main(String[] args) throws IOException {
        String[] enderecos = new String[] {"123.19.2.3" , "127.0.1.1" , "127.0.0.2" , "127.0.0.1" , "192.0.0.256" , "0.168.1.36"
                , "1.1.0.99" , "200.135.80.9" , "192.168.1.1" , "8.35.67.74" , "257.32.4.5" , "85.345.1.2" , "1.2.3.4"
                , "9.8.234.5" , "192.168.0.256"};
        String enderecosValidos = "";
        String enderecosInvalidos = "";
        String regex = "^(([1-9].|[1-9][0-9].|1[0-9][0-9].|2[0-4][0-9].|25[0-5].)([0-9].|[1-9][0-9].|1[0-9][0-9].|2[0-4][0-9].|25[0-5].)([0-9].|[1-9][0-9].|1[0-9][0-9].|2[0-4][0-9].|25[0-5].)([0-9].|[1-9][0-9].|1[0-9][0-9].|2[0-4][0-9].|25[0-5].))$";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < enderecos.length; i++) {
            Matcher matcher = pattern.matcher(enderecos[i]);
            if (matcher.find()) {
                enderecosValidos = enderecosValidos + "\n" + enderecos[i];
            } else {
                enderecosInvalidos = enderecosInvalidos + "\n" + enderecos[i];
            }
        }
        criarArquivo(enderecosValidos, enderecosInvalidos);
    }
    static void criarArquivo(String enderecoValido, String enderecoInvalido) throws IOException {
        Path path = Path.of("C:\\Users\\Pichau\\Desktop\\Endereços.txt");
        if(Files.notExists(path)){
            Files.createFile(path);
        }
        String texto = "[Endereços Validos]:\n" + enderecoValido + "\n\n[Endereços Invalidos]:\n" + enderecoInvalido;
        Files.writeString(path, texto);
    }
}