package unidad2;

public class PrimerHilo extends Thread{
    //Declaramos un entero.
    private int numero;
    //Creamos el cosntructor de la clase
    PrimerHilo (int x){
        this.numero = x;
    }
    //Establecemos el método RUN, el cual se encarga de establecer que instrucciones va a contener el hilo.
    public void run(){
        for(int i = 0; i< this.numero; i++){
            System.out.println("En el hilo ... " + i);
        }
    }
    //Declaramos un método main para instanciar e iniciar el hilo
    public static void main(String[] args){
        PrimerHilo hilo = new PrimerHilo(10);
        //Iniciamos el hilo con el método START.
        hilo.start();
    }
}
