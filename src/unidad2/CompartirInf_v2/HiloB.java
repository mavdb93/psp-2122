package unidad2.CompartirInf_v2;

public class HiloB extends Thread{
    private Contador contador;
    HiloB(String nombre, Contador c){
        this.contador = c;
        setName(nombre);
    }
    public void run() {

        for (int i = 0; i < 300; i++) {
            contador.decrementa();
        }
        System.out.println(getName() + " contador vale " + contador.valor());

    }
}
