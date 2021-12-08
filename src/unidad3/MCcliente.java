package unidad3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MCcliente {
        public static void main(String[]args){
        //Creamos el socket multicast
        int Puerto = 12345;
            try {
                MulticastSocket  multicastSocket = new MulticastSocket(Puerto);
                InetAddress grupo = InetAddress.getByName("225.0.0.1");

                //El cliente se une al grupo
                multicastSocket.joinGroup(grupo);
                String mensaje = "";
                //Creamos un bucle eterno hasya insertar *
                while(!mensaje.trim().equals("*")){
                    byte[] buffer = new byte[1000];
                    //Se recibe el paquete desde el servdior multicast
                    DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
                    multicastSocket.receive(paqueteRecibido);

                    mensaje = new String(paqueteRecibido.getData());
                    System.out.println("He recibido desde el servidor: " + mensaje.trim());
                }
                //Dejamos el grupo
                multicastSocket.leaveGroup(grupo);
                multicastSocket.close();
                System.out.println("Socket cerrado.");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
}
