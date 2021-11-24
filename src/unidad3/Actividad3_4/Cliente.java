package unidad3.Actividad3_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
//El cliente envía al servidor un INT y este se lo devuelve al cuadrado.
public class Cliente {
    public static void main(String[] args) {
        int numAEnviar = 5;
        int puerto = 6500;
        String host = "localhost";
        Socket cliente = null;
        try{
            System.out.println("Intentando conectar con servidor desde puerto "+puerto);
            cliente = new Socket(host,puerto);

            //Mandamos número.
            DataOutputStream flujoEscritura = new DataOutputStream(cliente.getOutputStream());
            flujoEscritura.writeInt(numAEnviar);
            System.out.println("Número enviado al servidor.");

            //Leemos dato del servidor.
            DataInputStream flujoLectura = new DataInputStream(cliente.getInputStream());
            int numRecibido = flujoLectura.readInt();
            System.out.println("Según el servidor el cuadrado de "+numAEnviar+" es: "+numRecibido);

            flujoEscritura.close();
            flujoLectura.close();
            cliente.close();

        }catch(IOException ioe){}
    }
}
