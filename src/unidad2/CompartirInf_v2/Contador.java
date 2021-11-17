package unidad2.CompartirInf_v2;

public class Contador {
    private int c = 0;
    Contador(int cont){
        this.c = cont;
    }
    synchronized public void incrementa(){

        this.c = this.c + 1;
        System.out.println("Valor contador: " + c);
    }
    synchronized public void decrementa(){

        this.c = this.c - 1;
        System.out.println("Valor contador: " + c);
    }
    synchronized public int valor(){
        return this.c;

    }
}
