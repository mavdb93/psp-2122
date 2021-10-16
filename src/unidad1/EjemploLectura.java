package unidad1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EjemploLectura {
    public static void main(String[] args){
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String texto;
        try {
            System.out.println("Escriba una cadena:");
            texto = lector.readLine();
            System.out.println("Cadena escrita: " + texto);
            lector.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
