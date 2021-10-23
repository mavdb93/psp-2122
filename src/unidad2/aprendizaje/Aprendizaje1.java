package unidad2.aprendizaje;

public class Aprendizaje1 extends Thread{
    /*
    Crea una clase que extienda de Thread que tenga por funcionalidad visualizar el mensaje “Hola mundo”.
    Crea un programa Java que visualice el mensaje anterior 5 veces creando para ello 5 hilos diferentes usando la clase creada anteriormente.
    Modifica el mensaje “Hola mundo” en el hilo, de forma que en
    todo momento se cea de que hilo se trata
    */
    public Aprendizaje1(){

    }
    public void run(){
        for(int i = 0; i<5; i++){
            System.out.println("Hola mundo. Estoy en el hilo con ID " + getId());
        }
        //System.out.println("FIN DE LA EJECUCIÓN DEL HILO " + getId());
    }
    public static void main(String[] args){
        Aprendizaje1 hilo1 = new Aprendizaje1();
        Aprendizaje1 hilo2 = new Aprendizaje1();
        Aprendizaje1 hilo3 = new Aprendizaje1();
        Aprendizaje1 hilo4 = new Aprendizaje1();
        Aprendizaje1 hilo5 = new Aprendizaje1();
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
    }
}
