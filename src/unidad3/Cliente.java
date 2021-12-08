package unidad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000;
        Socket cliente = new Socket(host,puerto);
        //CREAMOS LOS FLUJOS DE ENTRADA Y SALIDA
        PrintWriter flujoSalida = new PrintWriter(cliente.getOutputStream(),true);
        BufferedReader flujoEntrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

        //CREAMOS FLUJO PARA ENTRADA STANDARD
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String cadena = "";
        String eco = "";
        do{
            System.out.println("Introduce una cadena: ");
            cadena = entrada.readLine();
            flujoSalida.println(cadena); //Le enviamos la cadena al servidor.
            eco = flujoEntrada.readLine(); //Recibimos la cadena desde el servidor.
            System.out.println(" => ECO: "+eco);
        }while(!cadena.trim().equals("*"));
        flujoSalida.close();
        flujoEntrada.close();
        entrada.close();
        cliente.close();
        System.out.println("Envío finalizado.");
    }
}
