package unidad1;

import java.io.File;

public class Ejemplo8 {
    public static void main(String[]args) {
        ProcessBuilder pb = new ProcessBuilder("ls","-al");
        //El de error primero
        File ficheroError = new File("errorEjemplo8.txt");
        pb.redirectError(ficheroError);
        File ficheroBat = new File("./src/fichero_con_comando.bat");
        File ficheroSalida = new File("salidaEjemplo8.txt");
        pb.redirectOutput(ficheroSalida);
        pb.redirectInput(ficheroBat);
        try{
            pb.start();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
