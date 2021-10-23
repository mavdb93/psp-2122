package unidad2;

import java.applet.Applet;
import java.awt.*;

public class AppletThread extends Applet implements Runnable {

    private Thread hilo = null;
    public void init(){

    }
    public void start(){
        if(hilo == null){
            //crea el hilo
            hilo = new Thread(this);
            hilo.start();
        }
    }

    public void run(){
        Thread hiloActual = Thread.currentThread();
        while(hiloActual == hilo){
            //tarea repetittiva
        }
    }

    public void stop(){
        hilo = null;
    }
    public void paint(Graphics g){

    }

}
