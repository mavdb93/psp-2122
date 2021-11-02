package unidad2;

import java.util.Scanner;

/*
Modifica la clase para definir una variable contador que se inicie en 0
En el metodo run y dentro de un bucle que controle el final del hilo mediante una variable, ese contador se incrementara en 1 y se mostrara por pantalla.
Debes incluir un sleep para que se vean los numeros.

Luego llama al metodo esperandoParaReanudar y suspende el hilo (el sleep lo podemos hacer antes o despues de esto)
Crea en la clase un metodo que devuelva el valor del contador. Al finalizar el bucle se debe indicar con un mensaje.

Para probar las clases haz un método main en el que metas una cadena por teclado.
Este proceso se debe repetir hasta meter *. Pero si introduces "S" el hilo se debe suspender
Si se pulsa "R" se reanudará.

al finalziar el proceso repetitivo se visualizará el valor del contador y finalizará el hilo. Comprueba todos los mensajes
para ver que se visualizan correctamente.

HAZ EL EJERCICIO 8 TAMBIEN.
* */
public class MyHilo extends Thread{
    private SolicitaSuspender suspender = new SolicitaSuspender();
    public static int contador = 0;
    public String finalizar = "*";
    public static boolean enmarcha = true;

    public static String entradaDatos="";


    public void Suspende(){
        suspender.set(true);
    }
    public void Reanuda(){
        suspender.set(false);
    }
    public void run(){
        try{
            while (enmarcha){
                suspender.esperandoParaReanudar();
                contador++;
                sleep(1000);

            }

        }catch(InterruptedException ie){
            ie.getStackTrace();
        }
    }

    public static int getValorContador(){
        return contador;
    }

    public static void main(String[] args){
        MyHilo hilo = new MyHilo();
        hilo.start();

        try{

            do{
                Scanner entrada;
                System.out.println("Introduce un valor");
                entrada = new Scanner(System.in);
                entradaDatos = entrada.nextLine();

                if(entradaDatos.equalsIgnoreCase("S")){
                    hilo.Suspende();
                    System.out.println("Se ha suspendido el hilo ");
                }else if(entradaDatos.equalsIgnoreCase("R")){
                    hilo.Reanuda();
                    System.out.println("Se ha reanudado el hilo");
                }
                System.out.println("El contador es igual a: " + MyHilo.getValorContador());
            }while(!entradaDatos.equalsIgnoreCase("*"));
            enmarcha = false;
            System.out.println("Se ha repetido el hilo " + MyHilo.getValorContador() + " veces");

        }catch(Exception e){
            e.getStackTrace();
        }
    }
}
