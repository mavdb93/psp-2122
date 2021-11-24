package unidad3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPejemplo1Cliente {
    public static void main(String[] args) throws IOException {
        String host="localhost";
        int puerto = 6000;
        System.out.println("PROGRAMA CLIENTE INICIADO....");
        try{
            Socket Cliente = new Socket(host,puerto);
            //Creando flujo de salida al servidor.
            DataOutputStream flujoEscritura = new DataOutputStream(Cliente.getOutputStream());
            //Enviando saludo al servidor.
            flujoEscritura.writeUTF("Saludos al SERVIDOR desde CLIENTE!");
            //Creando flujo de entrada (lectura) al servidor
            DataInputStream flujoLectura = new DataInputStream(Cliente.getInputStream());
            //El servidor envia un mensaje
            System.out.println("El servidor ha dicho: "+flujoLectura.readUTF());
            //Cerramos Streams y Sockets.
            flujoEscritura.close();
            flujoLectura.close();
            Cliente.close();

        }catch(IOException ioe){
            ioe.getMessage();
        }




    }
}
