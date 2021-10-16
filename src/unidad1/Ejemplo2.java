package unidad1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejemplo2 {
    public static void main(String[] args) {
        try {
            //LA COMA ES IMPORTANTE
            Process pb = new ProcessBuilder("ls","-l").start();
            BufferedReader lector = new BufferedReader(new InputStreamReader(pb.getInputStream()));
            String frase;
            while((frase = lector.readLine()) != null){
                System.out.println(frase);
            }
            int exitVal;
            try{
                exitVal = pb.exitValue();
                if(exitVal == 0){
                    //Si el valor de salida es 0 quiere decir que no se han produco errores al ejecutar el proceso.
                    System.out.println("El valor de salida es: "+exitVal);
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
