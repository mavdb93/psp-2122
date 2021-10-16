package unidad1;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Ejemplo3 {
    public static void main(String[] args) {
        File archivo = new File("./out/production/psp-2122/");
        try{
            ProcessBuilder pb = new ProcessBuilder("java","unidad1.Ejemplo2");
            pb.directory(archivo);
            System.out.println("Estoy mirando aqui: "+pb.directory());
            Process p = pb.start();
            BufferedReader lector = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String frase;
            while((frase = lector.readLine()) != null){
                System.out.println(frase);
            }
            int exitVal;
            exitVal = p.exitValue();
            try{
                if(exitVal == 0){
                    //Si el valor de salida es 0 quiere decir que no se han produco errores al ejecutar el proceso.
                    System.out.println("El valor de salida es: "+exitVal);
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
