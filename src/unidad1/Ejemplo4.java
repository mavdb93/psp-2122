package unidad1;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Ejemplo4 {
    public static void main(String[]args){
        File archivo = new File("./out/production/psp-2122");
        ProcessBuilder pb = new ProcessBuilder("java","unidad1.EjemploLectura");
        pb.directory(archivo);
        try{
            Process p = pb.start();
            OutputStream flujoEscritura = p.getOutputStream();
            flujoEscritura.write("Saludos!\n".getBytes());
            flujoEscritura.flush();

            BufferedReader lector = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String frase;
            while((frase = lector.readLine()) != null){
                System.out.println(frase);
            }
            flujoEscritura.close();
            int extVal;
            extVal = p.exitValue();
            if(extVal == 0){
                System.out.println("El valor de salida es: "+extVal);

            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
