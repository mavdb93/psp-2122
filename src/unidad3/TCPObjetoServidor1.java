package unidad3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPObjetoServidor1 {
    public static void main(String[] args) throws ClassNotFoundException {
        int puerto = 6000;
        try {
            ServerSocket socketServidor = new ServerSocket(puerto);
            System.out.println("Esperando al cliente .......");
            Socket cliente = socketServidor.accept();

            //Preparamos un flujo de escritura de objetos.
            ObjectOutputStream flujoSalida = new ObjectOutputStream(cliente.getOutputStream());

            //Preparamos el objeto
            Persona p = new Persona("Paco",25);
            flujoSalida.writeObject(p);
            System.out.println("Enviado: "+p.getNombre()+" de "+p.getEdad()+" años");

            //Se obtiene un stream para ller objetos
            ObjectInputStream flujoLectura = new ObjectInputStream(cliente.getInputStream());
            Persona datoRecibido = (Persona) flujoLectura.readObject();

            System.out.println("El cliente nos ha respondido con "+datoRecibido.getNombre()+" de "+datoRecibido.getEdad()+" años.");
            flujoLectura.close();
            flujoSalida.close();
            cliente.close();
            socketServidor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
