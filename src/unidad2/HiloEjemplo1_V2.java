package unidad2;
public class HiloEjemplo1_V2 extends Thread{
    //Creamos el constructor
    public HiloEjemplo1_V2(String nombre) {
        super(nombre);
        System.out.println("Creando HILO:" + getName());
        //Establecemos el método RUN, el cual se encarga de establecer que instrucciones va a contener el hilo.
    }
    public void run(){
        for(int i = 0; i< 5; i++){
            System.out.println("Hilo " + getName() + " C = " + i);
        }
    }
    public static void main(String[] args){
        //Y aqui estamos utilizando hilos de Ejemplo1
        HiloEjemplo1 h1 = new HiloEjemplo1("Hilo 1");
        HiloEjemplo1 h2 = new HiloEjemplo1("Hilo 2");
        HiloEjemplo1 h3 = new HiloEjemplo1("Hilo 3");
        h1.start();
        h2.start();
        h3.start();
        System.out.println("3 hilos iniciados ...");
    }
}
