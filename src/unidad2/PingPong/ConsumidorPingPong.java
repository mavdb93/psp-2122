package unidad2.PingPong;

public class ConsumidorPingPong implements Runnable{
    String valorPingPong;
    Cola c;
    public ConsumidorPingPong(Cola c){
        this.c = c;
    }
    public void run(){
        for (int i = 0; i<20; i++) {
            valorPingPong = c.getValor();
            System.out.println(valorPingPong);
        }
    }
}
