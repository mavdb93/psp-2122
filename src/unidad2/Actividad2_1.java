package unidad2;

public class Actividad2_1 {

    public static void main(String[] args){
        TIC hiloTic = new TIC();
        TAC hiloTac = new TAC();
        hiloTic.start();
        hiloTac.start();
    }
}
