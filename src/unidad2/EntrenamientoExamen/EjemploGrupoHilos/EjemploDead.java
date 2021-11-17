package unidad2.EntrenamientoExamen.EjemploGrupoHilos;

public class EjemploDead implements Runnable{
    boolean matarHilo = false;
    @Override
    public void run() {
        while(!matarHilo){
            System.out.println("Hola");
        }
    }
    public void matarHilo(){
        this.matarHilo = true;
    }
    public static void main(String[] args) {
        EjemploDead h = new EjemploDead();
        Thread hilo1 = new Thread(h);
        hilo1.start();
        for (int i=0; i<1000000000; i++);
        h.matarHilo();
    }
}
