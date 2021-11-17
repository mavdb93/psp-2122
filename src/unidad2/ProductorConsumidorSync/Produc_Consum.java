package unidad2.ProductorConsumidorSync;

public class Produc_Consum {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Productor produc1 = new Productor(cola, 1);
        Consumidor consu1 = new Consumidor(cola, 1);
        produc1.start();
        consu1.start();
    }
}
