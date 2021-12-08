package unidad3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPObjetoCliente1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String host = "localhost";
        int puertoDestino = 6000;

        System.out.println("CLIENTE INICIANDOSE.....");
        Socket cliente = new Socket(host,puertoDestino);

        //Creamos un flujo de lectura de datos
        ObjectInputStream flujoLectura = new ObjectInputStream(cliente.getInputStream());

        //Recibimos la persona desde el servidor
        Persona per = (Persona) flujoLectura.readObject();
        System.out.println("Se ha recibido desde el servidor a "+per.getNombre()+" de "+per.getEdad()+" años.");

        //Modificamos el obejto recbidio
        per.setNombre("Manolo");
        per.setEdad(43);

        //Creamos el flujo de escritura para devolver la respuesta al servidor
        ObjectOutputStream flujoEscritura = new ObjectOutputStream(cliente.getOutputStream());
        flujoEscritura.writeObject(per);
        System.out.println("Se ha enviado al servidor a "+per.getNombre()+" de "+per.getEdad()+" años.");

        flujoEscritura.close();
        flujoLectura.close();
        cliente.close();
    }
}
