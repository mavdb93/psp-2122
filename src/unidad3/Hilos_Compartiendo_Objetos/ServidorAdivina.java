package unidad3.Hilos_Compartiendo_Objetos;

import unidad2.EjemploBloqueoHilos.ObjetoCompartido;
import unidad3.HiloServidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorAdivina {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(6001);
        System.out.println("Servidor iniciado...");

        //Número a adivinar: entr 1 y 25:
        int num = (int) (1+25*Math.random());
        System.out.println("EL NÚMERO QUE SE DEBE ADIVINAR ES => " + num);
        //Todos los hilos comparten el objeto siguiente:
        ObjetoQueSeComparte objetoCompartido = new ObjetoQueSeComparte(num);
        int idCliente = 0;
        while(true){
            Socket cliente = servidor.accept();
            idCliente++;
            HiloServidorAdivina hilo = new HiloServidorAdivina(cliente,objetoCompartido,idCliente);
            hilo.start();
        }
    }
}
