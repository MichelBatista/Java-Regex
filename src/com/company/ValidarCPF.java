package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarCPF {
    public static void main(String[] args) throws IOException {
        String[] cpfs = new String[]{"123.192.512-32" , "127.0.1-1" , "127.0.0-2" , "127.321.321-31" , "192.0.0-256" , "0.168.1-36"
                , "123.123.123-12" , "200.135.80-129" , "192.168.112-14" , "8.35.67-74" , "257.32.4-5" , "853.345.122-22" , "1.2.3-4"
                , "9.8.234.5" , "192.168.0-256"};
        String cpfsValidos = "";
        String cpfsInvalidos = "";
        String regex = "[0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][0-9]{2}";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < cpfs.length; i++){
            Matcher matcher = pattern.matcher(cpfs[i]);
            if(matcher.find()) {
                cpfsValidos = cpfsValidos + "\n" + cpfs[i];
            } else {
                cpfsInvalidos = cpfsInvalidos + "\n" + cpfs[i];
            }
        }
        criarArquivo(cpfsValidos, cpfsInvalidos);
    }
    static void criarArquivo(String informaçaoValida, String informaçaoInvalida) throws IOException {
        Path path = Path.of("C:\\Users\\Pichau\\Desktop\\cpfs.txt");
        if(Files.notExists(path)){
            Files.createFile(path);
        }
        String texto = "[CPFs Validos]:\n" + informaçaoValida + "\n\n[CPFs Invalidos:]\n" + informaçaoInvalida;
        Files.writeString(path, texto);
    }
}
