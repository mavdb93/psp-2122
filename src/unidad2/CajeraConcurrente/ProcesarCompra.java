package unidad2.CajeraConcurrente;

public class ProcesarCompra extends Thread{
    Cajera cajera;
    Cliente cliente;
    //Tiempo inicial de referencia
    long initialTime = System.currentTimeMillis();
    public ProcesarCompra(Cajera cajera,Cliente cliente){
        this.cajera = cajera;
        this.cliente = cliente;
    }
    public void run(){
        cajera.procesarCompra(cliente,initialTime);
    }
}
