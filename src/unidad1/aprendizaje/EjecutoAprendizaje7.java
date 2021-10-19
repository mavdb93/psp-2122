package unidad1.aprendizaje;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class EjecutoAprendizaje7 {
    public static void main(String[] args){
        File archivo = new File("./out/production/psp-2122");
        ProcessBuilder constructor = new ProcessBuilder("java", "unidad1.aprendizaje.aprendizaje7");
        constructor.directory(archivo);
        try {
            Process proceso = constructor.start();

            BufferedReader flujoLectura = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String textoLeido;
            while((textoLeido = flujoLectura.readLine())!= null){
                System.out.println(textoLeido);
            }
            OutputStream flujoEscritura = proceso.getOutputStream();
            flujoEscritura.write("Hola holita".getBytes());
            flujoEscritura.flush();
            int exitVal;
            try{
                exitVal =  proceso.exitValue();
                if(exitVal == 0){
                    //Si el valor de salida es 0 quiere decir que no se han produco errores al ejecutar el proceso.
                    System.out.println("El valor de salida es: "+exitVal);
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
