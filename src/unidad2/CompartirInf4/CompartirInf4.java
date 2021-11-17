package unidad2.CompartirInf4;

public class CompartirInf4 {
    public static void main(String[] args) {
        Cuenta c = new Cuenta(40);
        SacarDinero sd1 = new SacarDinero("Ana",c);
        SacarDinero sd2 = new SacarDinero("Juan",c);
        sd1.start();
        sd2.start();
    }
}
