package unidad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Locale;

public class HiloServidor extends Thread{
    BufferedReader fentrada;
    PrintWriter fsalida;
    Socket socket = null;

    public HiloServidor(Socket s) throws IOException {
        socket = s;
        //CREAMOS LOS FLUJOS DE ENTRADA Y SALIDA CON EL CLIENTE
        fsalida = new PrintWriter(socket.getOutputStream(),true);
        fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    public void run(){
        String cadena = "";
        System.out.println("COMUNICO CON: "+socket.toString());
        while(!cadena.trim().equals("*")){
            try {
                cadena = fentrada.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fsalida.println(cadena.trim().toUpperCase());
        }
        System.out.println("FIN CON: " + socket.toString());
        try {
            fsalida.close();
            fentrada.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
