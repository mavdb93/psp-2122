package unidad2.EjemploProductorConsumidor;

public class Cola {
    private int numero;
    private boolean disponible = false;
    public int get(){
        if(disponible){
            disponible = false;
            return numero;
        }
        return -1;

    }
    public void put(int num){
       this.numero = num;
       this.disponible = true;
    }
}
