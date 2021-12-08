package unidad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MCservidor {
    public static void main(String[] args) {

        //Flujo de entrada estandard
        BufferedReader bufferLectura = new BufferedReader(new InputStreamReader(System.in));
        //Creamos el socket multicast.
        try {
            MulticastSocket multicasSocket = new MulticastSocket();
            //Establecemos dirección y grupo al grupo multicast
            int puerto = 12345;
            InetAddress grupo = InetAddress.getByName("225.0.0.1");

            String cadena = "";
            //Creamos un bucle eterno hasya insertar *
            while(!cadena.trim().equals("*")){
                System.out.println("Datos a enviar al grupo: ");
                cadena = bufferLectura.readLine();
                //Enviando la cadena a todo el grupo
                DatagramPacket paqueteDatagramas = new DatagramPacket(cadena.getBytes(),cadena.getBytes().length,grupo,puerto);
                multicasSocket.send(paqueteDatagramas);
            }
            //Cerramos el socket
            multicasSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
