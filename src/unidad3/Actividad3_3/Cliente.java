package unidad3.Actividad3_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Locale;

public class Cliente {
    public static void main(String[] args) {
        int puerto = 6500;
        String host = "localhost";
        Socket cliente = null;
        try{
            System.out.println("Intentando conectar con servidor desde puerto "+puerto);
            cliente = new Socket(host,puerto);

            //Leemos datos del servidor.
            DataInputStream flujoLectura = new DataInputStream(cliente.getInputStream());
            String mensajeRecibido = flujoLectura.readUTF();
            System.out.println("El cliente nos ha mandado este mensaje: "+mensajeRecibido);

            //Mandamos respuesta.
            DataOutputStream flujoEscritura = new DataOutputStream(cliente.getOutputStream());
            flujoEscritura.writeUTF(mensajeRecibido.toLowerCase());
            System.out.println("Mensaje enviado al servidor.");

            flujoEscritura.close();
            flujoLectura.close();
            cliente.close();
        }catch(IOException ioe){}
    }
}
