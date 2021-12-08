package unidad3.Hilos_Compartiendo_Objetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloServidorAdivina extends Thread {
    ObjectInputStream flujoDeLectura;
    ObjectOutputStream flujoEscritura;
    Socket socket = null;
    ObjetoQueSeComparte objetoCompartido;
    int id;
    int intentos = 0;

    public HiloServidorAdivina(Socket s, ObjetoQueSeComparte objeto, int id){
        this.socket = s;
        this.objetoCompartido = objeto;
        this.id = id;
        try{
            flujoEscritura = new ObjectOutputStream(socket.getOutputStream());
            flujoDeLectura = new ObjectInputStream(socket.getInputStream());
        }catch(IOException ioe){
            System.out.println("ERROR DE E/S EN HILOSERVIDOR.");
            ioe.printStackTrace();
        }
    }

    public void run(){
        System.out.println("=> CLIENTE CONECTADO: " + id);
        //PREPARAMOS EL PRIMER ENVÍO DE DATOS DEL CLIENTE
        Datos datosDelCliente = new Datos("Adivina un NÚMERO ENTRE 1 y 25",intentos,id);
        if(objetoCompartido.seAcabo()){
            datosDelCliente.setCadena("LO SENTIMOS, EL JUEGO HA TERMINADO PORQUE SE HA ADIVINADO EL NÚMERO,");
            datosDelCliente.setJuega(false); // YA NO EXSITE EL JUEGO

        }
        try{
            flujoEscritura.reset();
            flujoEscritura.writeObject(datosDelCliente);
        }catch (IOException ioe){
            System.out.println("ERROR EN EL HILO AL REALIZAR EL PRIMER ENVÍO AL JUGADOR CON ID:"+id);
            return;
        }
        while(!objetoCompartido.seAcabo() || !(datosDelCliente.getIntentos() == 5)){
            int numCliente = 0;
            try{
                //RECIBIR DATOS DEL CLIENTE;

                // DA ERROR AQUI
                Datos dat = (Datos)flujoDeLectura.readObject();
                numCliente = Integer.parseInt(dat.getCadena());
                System.out.println("Pasa por aqui!");
            }catch (IOException ioe){
                System.out.println(ioe.getMessage());
                System.out.println("Error en el Hilo al leer del jugador con ID: "+ id);
                break;
            }catch (ClassNotFoundException cnfe){
                cnfe.printStackTrace();
                break;
            }
            // JUGAR EL NÚMERO
            String cadena = objetoCompartido.nuevaJugada(id,numCliente);
            intentos++;
            datosDelCliente = new Datos(cadena,intentos,id);

            if(objetoCompartido.seAcabo()){
                datosDelCliente.setJuega(false);
                if(id == objetoCompartido.getIdGanador()){
                    datosDelCliente.setGana(true);
                }
                try{
                    //INTENTAREMOS ENVIAR DATOS AL CLIENTE
                    flujoEscritura.reset();
                    flujoEscritura.writeObject(datosDelCliente);
                }catch (IOException ioe){
                    System.out.println("Error escribiendo en flujo de salida dle jugador: " + id + " * "+ ioe.getMessage());
                    break;
                }catch (NullPointerException npe){
                    System.out.println("El jugador con ID: "+ id+" se ha desconectado.");
                    break;
                }
            }

            if(objetoCompartido.seAcabo()){
                System.out.println("EL JUEGO SE HA ACABADO.........");
                System.out.println("\t==> DESCONECTADO: "+id);

            }

            try{
                flujoEscritura.close();
                flujoDeLectura.close();
                socket.close();
            }catch (IOException ioe){
                System.out.println("Error en el Hilo al cerrar cliente con ID: "+id);
                ioe.printStackTrace();
            }
        }

    }

}
