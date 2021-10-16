package unidad1;

import java.io.*;

//Ejemplo modificado para adaptarse a la actividad 1.7
public class EjemploLectura {
    public static void main(String[] args) throws IOException{

        File archivoLectura = new File("Actividad1_7_texto.txt");
        File archivoError = new File("Actividad1_7_ERROR.txt");
        ProcessBuilder pb = new ProcessBuilder();
        pb.redirectError(archivoError);
        pb.redirectInput(archivoLectura);
        int letra;
        Process p = pb.start();
        System.out.println("Procedemos a leer el archivo:");
        System.out.println(pb.redirectInput().toString());
        InputStreamReader lector = new InputStreamReader(p.getInputStream());
            while((letra = lector.read()) != -1){
                System.out.print((char)letra);
            }


        lector.close();

    }
}
