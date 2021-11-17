package unidad2.CompartirInf4;

public class SacarDinero extends Thread{

    private Cuenta cuen;
    String nombre;
    SacarDinero(String nom, Cuenta c) {
        super(nom);
        this.cuen = c;
    }

    public void run(){
        for(int i = 0; i<=4; i++){
            cuen.retirarDinero(10,getName());
        }
    }
}
