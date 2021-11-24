package unidad3.Actividad3_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//El cliente envía al servidor un INT y este se lo devuelve al cuadrado.
public class Servidor {
    public static void main(String[] args) {
        int puerto = 6500;
        int numRecibido = 0;
        int respuesta;
        ServerSocket servidor;
        Socket conexionCliente = null;
        try{
            System.out.println("ESPERANDO PETICIÓN aw DEL CLIENTE POR EL PUERTO "+puerto);
             servidor = new ServerSocket(puerto);
             conexionCliente = servidor.accept();
             System.out.println("El Cliente ha mandado una petición de conexión.");

            //Leemos número del cliente
            DataInputStream flujoLectura = new DataInputStream(conexionCliente.getInputStream());
            numRecibido = flujoLectura.readInt();
            System.out.println("El cliente ha mandado el número: "+ numRecibido);

             //Escribimos un dato al cliente:
            respuesta = numRecibido*numRecibido;
            System.out.println("Escriendo respuesta -> "+ respuesta);
            DataOutputStream flujoEscritura = new DataOutputStream(conexionCliente.getOutputStream());
            flujoEscritura.writeInt(respuesta);

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
