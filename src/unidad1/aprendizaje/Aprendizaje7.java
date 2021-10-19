package unidad1.aprendizaje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Aprendizaje7 {
    //Crea un programa Java que lea cadenas desde la entrada estándar hasta escribir un *. A continuación, crea otro programa que ejecute el anterior.
    public static void main(String[] args) throws IOException {
        //ProcessBuilder constructor = new ProcessBuilder();
        //try{
            //Process proceso = constructor.start();
            BufferedReader flujoLector = new BufferedReader(new InputStreamReader(System.in));
            String textoInsertado;
            System.out.println("Introduzca texto por teclado. Podrá seguir escribiendo hasta introducir '*'");
            do {
                textoInsertado = flujoLector.readLine();
                System.out.println(textoInsertado);
            } while (!textoInsertado.contains("*"));
        /*}catch(Exception e){
            System.out.println(e.getMessage());
        }*/

    }
}
