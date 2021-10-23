package unidad2;

public class HiloEjemplo2 extends Thread{
    public void run(){
        System.out.println(
                "Dentro del hilo   : " + Thread.currentThread().getName() +
                "\n\tPrioridad     : " + Thread.currentThread().getPriority() +
                "\n\tID            : " + Thread.currentThread().getId() +
                "\n\tHilos activos : " + Thread.currentThread().activeCount());

    }
    public static void main(String[] args){
        Thread.currentThread().setName("Principal");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().toString());

        HiloEjemplo2 hilo = null;

        for(int i = 0; i<3; i++){
            hilo = new HiloEjemplo2();
            hilo.setName("Hilo" + i);
            hilo.setPriority(i+1);
            hilo.start();
            System.out.println("Información del "+ hilo.getName() + ": " + hilo.toString());
        }
        System.out.println("3 Hilos creados...");
        System.out.println("Hilos ativos: " +  Thread.activeCount());
    }
}
