package unidad2.CompartirInf2;

public class HiloA extends Thread{
    private Contador contador;
    HiloA(String nombre, Contador c){
        this.contador = c;
        setName(nombre);
    }
    public void run() {
        synchronized (contador) {
            for (int i = 0; i < 300; i++) {
                contador.incrementa();
            }
            System.out.println(getName() + " contador vale " + contador.valor());
        }
    }
}
