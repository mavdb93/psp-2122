package unidad2.CompartirInf2;

public class Contador {
    private int c = 0;
    Contador(int cont){
        this.c = cont;
    }
    public void incrementa(){
        this.c = this.c + 1;
    }
    public void decrementa(){
        this.c = this.c - 1;
    }
    public int valor(){
        return this.c;
    }
}
