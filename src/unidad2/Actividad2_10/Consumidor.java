package unidad2.Actividad2_10;

public class Consumidor extends Thread{
    private Cola cola;
    private int numero;
    public Consumidor(Cola c, int num){
        this.cola = c;
        this.numero=num;
    }
    synchronized public void run(){
        int valor = 0;
        for(int i = 0; i<5; i++){
            valor = this.cola.get();
            System.out.println(String.format("    %d => Consumidor %d: consume: %d",i,this.numero,valor));
        }
        System.out.println("Fin Consumidor...");
    }
}
