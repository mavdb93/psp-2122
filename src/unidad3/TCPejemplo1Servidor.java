package unidad3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPejemplo1Servidor {
    public static void main(String[] args) throws IOException {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        Socket conexionDelCliente = null;
        System.out.println("PROGRAMA SERVDIR ESPERANDO PETICIÓN DEL CLIENTE....");
        try{
            conexionDelCliente = servidor.accept();

            //Creando flujo de entrada (lectura) al cliente
            DataInputStream flujoLectura = new DataInputStream(conexionDelCliente.getInputStream());
            //El CLIENTE envia un mensaje
            System.out.println("El CLIENTE ha dicho: "+flujoLectura.readUTF());

            //Creando flujo de salida al servidor.
            DataOutputStream flujoEscritura = new DataOutputStream(conexionDelCliente.getOutputStream());
            //Enviando saludo al servidor.
            flujoEscritura.writeUTF("Saludos al CLIENTE desde SERVIDOR!");
            //Cerramos Streams y Sockets.
            flujoEscritura.close();
            flujoLectura.close();
            conexionDelCliente.close();
            servidor.close();

        }catch(IOException ioe){
            ioe.getMessage();
        }




    }
}
