package unidad2.aprendizaje;

public class Aprendizaje2 implements Runnable{
    /*
    Crea una clase que implemente la interfaz Runnable cuya única funcionalidad sea visualizar el mensaje "Hola mundo"
    seguido de una cadena que se recibirá en el cosntructor (es decir al crear el objeto de ese tipo se enviará una cadena)
    y seguido del identificador del hilo.

    Crea un programa Java que visualice el mensaje anterior 5 veces creando para ello 5 hilos diferentes
    usnado la clase creada anteriormente. Luego haz que antes de visualziar el mendajse ese hilo espere un tiempo proporcional a su idnetificador.
    Par alelo deberás utilziar el método sleep

    */
    String cadena;
    public Aprendizaje2(String cadena){
        this.cadena = cadena;
    }
    public void run(){
        System.out.println("Hola mundo! " + this.cadena + " ID-HILO: " + Thread.currentThread().getId());
        try{
            Thread.sleep(1000L*Thread.currentThread().getId());
        }catch (InterruptedException e){
            e.getStackTrace();
        }
    }

    public static void main(String[] args){
        Thread hilo1 = new Thread(new Aprendizaje2("Cadena 1"));
        Thread hilo2 = new Thread(new Aprendizaje2("Cadena 2"));
        Thread hilo3 = new Thread(new Aprendizaje2("Cadena 3"));
        Thread hilo4 = new Thread(new Aprendizaje2("Cadena 4"));
        Thread hilo5 = new Thread(new Aprendizaje2("Cadena 5"));
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
    }
}
