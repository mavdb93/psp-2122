package unidad2.EjemploBloqueoHilos;

public class BloqueoHilos {
    public static void main(String[] args){
        ObjetoCompartido obj = new ObjetoCompartido();
        HiloCadena hilo1 = new HiloCadena(obj,"A");
        HiloCadena hilo2 = new HiloCadena(obj,"B");
        hilo1.start();
        hilo2.start();
    }
}
