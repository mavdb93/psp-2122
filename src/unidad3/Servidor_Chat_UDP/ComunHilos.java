package unidad3.Servidor_Chat_UDP;

import java.net.Socket;

public class ComunHilos {

    int CONEXIONES;
    int ACTUALES;
    int MAXIMO;
    Socket tabla[] = new Socket[MAXIMO];
    String mensajes;

    public ComunHilos(int maximo, int actuales, int conexiones, Socket[] tabla){
        this.MAXIMO = maximo;
        this.ACTUALES = actuales;
        this.CONEXIONES = conexiones;
        this.tabla = tabla;
        this.mensajes = "";
    }

    public ComunHilos(){
        super();
    }

    public int getMAXIMO(){
        return this.MAXIMO;
    }
    public void setMAXIMO(int MAXIMO){
        this.MAXIMO =  MAXIMO;
    }
    public int getCONEXIONES(){
        return this.CONEXIONES;
    }
    public int getACTUALES(){
        return this.ACTUALES;
    }
    public String getMensajes(){
        return this.mensajes;
    }
    public Socket getElementoTabla(int i){
        return this.tabla[i];
    }

    public synchronized void setCONEXIONES(int CONEXIONES){
        this.CONEXIONES = CONEXIONES;
    }
    public synchronized void setMensajes(String Mensajes){
        this.mensajes = Mensajes;
    }
    public synchronized void setACTUALES(int ACTUALES){
        this.ACTUALES =  ACTUALES;
    }

    public synchronized void addTabla(Socket s, int i){
        this.tabla[i] = s;
    }


}
