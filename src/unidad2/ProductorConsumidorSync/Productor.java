package unidad2.ProductorConsumidorSync;

public class Productor extends Thread{
    private Cola cola;
    private int numero;
    public Productor(Cola c, int num){
        this.cola = c;
        this.numero=num;
    }

    public void run(){
        for(int i = 0; i<5; i++){
            this.cola.put(i);
            //System.out.println(String.format("%d => Productor %d:  produce: %d",i,this.numero,i));
        }
    }
}
