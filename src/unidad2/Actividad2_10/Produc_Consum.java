package unidad2.Actividad2_10;

public class Produc_Consum {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Productor produc1 = new Productor(cola, 1);
        Consumidor consu1 = new Consumidor(cola, 1);
        Consumidor consu2 = new Consumidor(cola, 2);
        produc1.start();
        consu1.start();
        consu2.start();

    }
}
