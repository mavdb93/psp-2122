package unidad2.EjemploBloqueoHilos;

public class HiloCadena extends Thread{
    private ObjetoCompartido objeto;
    String cadena;

    public HiloCadena(ObjetoCompartido o, String cad){
        this.cadena = cad;
        this.objeto = o;
    }

    public void run(){
        //Ejemplo bloque synchronized, para poder coordinar ejeciciones sobre elementos compartidos.
        //Se utilzia para pdoer hacer waits y notifys concretos.
        synchronized (objeto) {
            for (int i = 0; i < 10; i++) {
                objeto.pintaCadena(this.cadena);
                objeto.notify();
                try{
                    objeto.wait();
                }catch(InterruptedException ie){}
            }
            objeto.notify();
        }
        System.out.println("\n"+this.cadena+" ha finalizado.");
    }
}
