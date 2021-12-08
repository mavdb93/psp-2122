package unidad3.Servidor_Chat_UDP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorChat {
    static final int MAXIMO = 10;

    public static void main(String[] args) throws IOException {
        int puerto = 44444;
        Socket tabla[];
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Servidor iniciado....");

        tabla = new Socket[MAXIMO];
        ComunHilos comun = new ComunHilos(MAXIMO,0,0,tabla);
        while (comun.getCONEXIONES() < MAXIMO){
            Socket socket = new Socket();
            socket = servidor.accept();

            comun.addTabla(socket,comun.getCONEXIONES());
            comun.setACTUALES(comun.getACTUALES()+1);
            comun.setCONEXIONES(comun.getCONEXIONES()+1);

            HiloServidorChat hilo = new HiloServidorChat(socket,comun);
            hilo.start();
        }
        servidor.close();
    }
}
