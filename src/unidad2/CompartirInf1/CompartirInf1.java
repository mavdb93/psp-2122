package unidad2.CompartirInf1;

public class CompartirInf1 {
    public static void main(String[] args) {
        Contador c = new Contador(100);
        HiloA hiloA = new HiloA("HiloA",c);
        HiloB hiloB = new HiloB("HiloB",c);
        hiloA.start();
        hiloB.start();
    }
}
