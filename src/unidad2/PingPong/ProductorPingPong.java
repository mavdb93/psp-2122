package unidad2.PingPong;

public class ProductorPingPong implements Runnable{
    String valorPingPong = "PING";
    Cola c;
    public ProductorPingPong(Cola c){
        this.c = c;
    }
    public void run(){
        for (int i = 0; i<20; i++) {
            c.setValor(valorPingPong);
            if (valorPingPong.equalsIgnoreCase("PING")) {
                //Cambiamos el valor del string

                this.valorPingPong = "   PONG";
            } else {
                this.valorPingPong = "PING";
            }
        }
    }
}
