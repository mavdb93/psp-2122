package unidad3.Servidor_Chat_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloServidorChat extends Thread{

    DataInputStream fentrada;
    Socket socket = null;
    ComunHilos comun;

    public HiloServidorChat(Socket s, ComunHilos comun){
        this.comun = comun;
        this.socket= s;
        try{
            //CREO FLUJO DE entrada para leer los mensjaes
            fentrada = new DataInputStream(socket.getInputStream());

        }catch (IOException ioe){System.out.println("Se ha producido un error de entrada y salida.");}
    }

    public void run(){
        System.out.println("NÚMERO DE CONEXIONES ACTUALES: " + comun.getACTUALES());
        //NADA MAS CONECTARSE LE ENVIAMOS TODOS LOS MENSAJES
        String texto = comun.getMensajes();
        enviarMensajeATodos(texto);

        while(true){
            String cadena = "";
            try{
                cadena = fentrada.readUTF();
                if(cadena.trim().equals("*")){
                    comun.setACTUALES(comun.getACTUALES() - 1);
                    System.out.println("NÚMERO DE CONEXIONES ACTUALES: " + comun.getACTUALES());
                    break;
                }
                comun.setMensajes(comun.getMensajes() + cadena + "\n");
                enviarMensajeATodos(comun.getMensajes());
            }catch (Exception e){
                break;
            }
        }
        //CERRAMOS EL SOCKET DLE CLIENTE
        try{
            socket.close();
        }catch (IOException ioe){
            ioe.getMessage();
        }

    }

    private void enviarMensajeATodos(String texto){
        int i;
        for(i = 0; i<comun.getCONEXIONES();i++){
            Socket s1 = comun.getElementoTabla(i);
            if(!s1.isClosed()){
                try{
                    DataOutputStream fsalida2 = new DataOutputStream(s1.getOutputStream());
                    fsalida2.writeUTF(texto);
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }
    }

}
