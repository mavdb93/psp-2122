package unidad3.Actividad3_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//El servidor envia al cliente un mensaje al cliente. El cliente debe devolverlo en minúsculas.
public class Servidor {
    public static void main(String[] args) {
        int puerto = 6500;
        String mensaje = "Hola mundo!";
        ServerSocket servidor;
        Socket conexionCliente = null;
        try{
            System.out.println("ESPERANDO PETICIÓN DEL CLIENTE POR EL PUERTO "+puerto);
             servidor = new ServerSocket(puerto);
             conexionCliente = servidor.accept();
             System.out.println("El Cliente ha mandado una petición de conexión.");
            //Escribimos un dato al cliente:
            System.out.println("Escriendo mensaje -> "+ mensaje);
            DataOutputStream flujoEscritura = new DataOutputStream(conexionCliente.getOutputStream());
            flujoEscritura.writeUTF(mensaje);

            //Leemos repsuesta del cliente
            DataInputStream flujoLectura = new DataInputStream(conexionCliente.getInputStream());
            mensaje = flujoLectura.readUTF();
            System.out.println("El cliente ha respondido: "+ mensaje);

            //Cerramos:
            flujoEscritura.close();
            flujoLectura.close();
            conexionCliente.close();
            servidor.close();
        }catch (IOException ioe){}

    }


    public Servidor() throws IOException {
    }
}
