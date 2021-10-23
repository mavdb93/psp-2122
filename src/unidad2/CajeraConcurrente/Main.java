package unidad2.CajeraConcurrente;

public class Main {
    public static void main(String[] args){
        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2,2,1,5,2,3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1,3,5,1,1});

        Cajera cajera1 = new Cajera("Cajera 1");
        Cajera cajera2 = new Cajera("Cajera 2");
        /*
        //Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        */
        //Ahora hay que hacer que cada procesar compra se aun hilo.
        /*
        cajera1.procesarCompra(cliente1,initialTime);
        cajera2.procesarCompra(cliente2,initialTime);
        */
        ProcesarCompra hilo1 = new ProcesarCompra(cajera1,cliente1);
        ProcesarCompra hilo2 = new ProcesarCompra(cajera2,cliente2);

        hilo1.start();
        hilo2.start();
    }
}
