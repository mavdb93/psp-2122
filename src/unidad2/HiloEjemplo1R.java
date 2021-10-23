package unidad2;

public class HiloEjemplo1R implements Runnable{
    //Creamos el constructor
    public HiloEjemplo1R() {
        System.out.println("Creando HILO:" + Thread.currentThread().getName());
        //Establecemos el método RUN, el cual se encarga de establecer que instrucciones va a contener el hilo.
    }
    public void run(){
        for(int i = 0; i< 5; i++){
            System.out.println("Hilo " + Thread.currentThread().getName() + " C = " + i);
        }
    }
    public static void main(String[] args){
        HiloEjemplo1R he1 = new HiloEjemplo1R();
        Thread h1 = new Thread(he1);
        h1.setName("Hilo 1");
        HiloEjemplo1R he2 = new HiloEjemplo1R();
        Thread h2 = new Thread(he1);
        h2.setName("Hilo 2");
        HiloEjemplo1R he3 = new HiloEjemplo1R();
        Thread h3 = new Thread(he1);
        h3.setName("Hilo 3");


        h1.start();
        h2.start();
        h3.start();
        System.out.println("3 hilos iniciados ...");
    }
}
