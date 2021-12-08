package unidad3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPservidor {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024];
        //Asociamos el socket a un puerto, por ejemplo el 12345
        try {
            DatagramSocket socketServidor = new DatagramSocket(12345);
            //Esperando datagrama
            System.out.println("Esperando datagrama....");
            DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
            socketServidor.receive(paqueteRecibido);
            int cantidadBytes = paqueteRecibido.getLength();
            String datos = new String(paqueteRecibido.getData());
            //Muestro lo obtenido
            System.out.println("Número de Bytes recibidos  : " + cantidadBytes);
            System.out.println("Contenido del paquete      : " + datos.trim());
            System.out.println("Puerto origen de los datos : " + paqueteRecibido.getPort());
            System.out.println("Ip origen de los datos     : " + paqueteRecibido.getAddress().getHostAddress());
            System.out.println("Ip servidor                : " + socketServidor.getLocalSocketAddress());
            System.out.println("Puerto del servidor        : " + socketServidor.getLocalPort());
            //CERRAMOS EL SOCKET DEL SERVIDOR
            socketServidor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
