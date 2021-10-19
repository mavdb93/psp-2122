package unidad1.aprendizaje;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Aprendizaje5 {
    //Crea un programa Java que visualice 5 veces la cadena que se se elvía desde los argumentos de main().
    //Si no se le envía ninguna cadena debe mostrar un mensaje y finalizar el programa ocn System.exit(1).
    public static void main(String[] args){
        File archivo = new File("./out/production/psp-2122/");
        ProcessBuilder constructor = new ProcessBuilder("java","unidad1.aprendizaje.CincoVeces", "Hola Mundo!");
        constructor.redirectOutput(new File("salidaAprendizaje6.txt"));
        constructor.directory(archivo);
        try{
            Process proceso = constructor.start();
            /*
            BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String frase;
            while((frase = lector.readLine()) != null){
                System.out.println(frase);
            }
            */

            int exitVal;
            try{
                exitVal = proceso.exitValue();
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
