package unidad1;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Ejemplo6 {
    public static void main(String[]args){
        ProcessBuilder pb = new ProcessBuilder();
        Map entorno = pb.environment();
        System.out.println("Las variables del entorno son:");
        System.out.println(entorno);
        File archivo = new File("./out/production/psp-2122");
        pb = new ProcessBuilder("java","unidad1.LeerNombre","María Jesús");
        List lista = pb.command();
        Iterator iterador = lista.iterator();
        System.out.println("\nArgumentos del comando:");
        while(iterador.hasNext()){
            System.out.println(iterador.next());
        }
        pb = pb.command("ls","-al");
        try {
            Process p = pb.start();
            BufferedReader lector = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String texto;
            while ((texto = lector.readLine()) != null) {
                System.out.println(texto);
            }
            lector.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
