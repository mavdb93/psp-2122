package unidad1;

import java.io.File;

public class Ejemplo7 {
    public static void main(String[]args) {
        ProcessBuilder pb = new ProcessBuilder("ls","-al");
        File ficheroSalida = new File("salida.txt");
        File ficheroError = new File("error.txt");
        pb.redirectError(ficheroError);
        pb.redirectOutput(ficheroSalida);
        try{
            pb.start();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
