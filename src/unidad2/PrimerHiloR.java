package unidad2;

public class PrimerHiloR implements Runnable{
    public void run(){
        System.out.println("Hola desde el Hilo! Usamos Runnable. Hilo: " + Thread.currentThread().getId());
    }
    public static void main(String[] args){
        PrimerHiloR hilo = new PrimerHiloR();
        //Como podemos ver para crear un hilo como Runnable tendremos que pasarselo al constructor de la clase Thread.
        Thread hiloReal = new Thread(hilo);
        hiloReal.start();
    }
}
