package unidad2.CompartirInf2;

public class HiloB extends Thread{
    private Contador contador;
    HiloB(String nombre, Contador c){
        this.contador = c;
        setName(nombre);
    }
    public void run() {
        synchronized (contador) {
            for (int i = 0; i < 300; i++) {
                contador.decrementa();
            }
            System.out.println(getName() + " contador vale " + contador.valor());
        }
    }
}
