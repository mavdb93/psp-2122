package unidad2.PingPong;

public class PrincipalPingPong {
        public static void main(String[] args) {
            Cola cola = new Cola();
            ProductorPingPong produc1 = new ProductorPingPong(cola);
            ConsumidorPingPong consu1 = new ConsumidorPingPong(cola);
            Thread hiloProductor = new Thread(produc1);
            Thread hiloConsumidor = new Thread(consu1);
            hiloProductor.start();
            hiloConsumidor.start();
        }
}
