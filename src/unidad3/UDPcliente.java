package unidad3;

import java.io.IOException;
import java.net.*;

public class UDPcliente {
    public static void main(String[] args) throws UnknownHostException,SocketException {

        try {
            //Definimos la Ip destino, en este caso trabajamos en local por lo que será localhost
            InetAddress IpDestino = InetAddress.getLocalHost();
            //Definimos el puerto al que queremos mandar el mensaje y el puerto desde el que vamos a mandarlo
            int puertoDestino = 12345;
            int puertoCliente = 34567;
            byte[] mensaje = new byte[1024];
            String saludo = "Saludos! Soy el cliente.";
            //Convertimos el mensaje en bytes.
            mensaje = saludo.getBytes();

            //Construimos el diagrama
            DatagramPacket paqueteEnvio = new DatagramPacket(mensaje,mensaje.length,IpDestino,puertoDestino);
            //Construimos el socket para enviar el diagrama
            DatagramSocket socketCliente = new DatagramSocket(puertoCliente);
            //Muestro lo enviado
            System.out.println("Número de Bytes enviados  : " + paqueteEnvio.getLength());
            System.out.println("Host destino de los datos : " + IpDestino.getHostName());
            System.out.println("Ip destino de los datos     : " + IpDestino.getHostAddress());
            System.out.println("Ip origen de los datos     : " + socketCliente.getLocalAddress());
            System.out.println("Puerto del cliente        : " + socketCliente.getLocalPort());
            System.out.println("Puerto del servidor        : " + paqueteEnvio.getPort());
            socketCliente.send(paqueteEnvio);
            socketCliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
