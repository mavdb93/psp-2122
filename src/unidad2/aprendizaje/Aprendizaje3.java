package unidad2.aprendizaje;

import java.io.*;

public class Aprendizaje3 extends Thread{
    /*
    Implemente un programa que reciba a través de sus argumentos una lista de ficheros de texto y cuente
    el número de caracteres que hay en cada fichero. Modifica el programa para que se cree un hilo por cada
    fichero a contar. Muestra lo que se tarda en contrar cada fichero en la primera tarea secuencial y usando hilos.
    */
    //Leemos el argumento:
    File documento;
    public Aprendizaje3(File documento){
        this.documento = documento;
    }

    public void run(){
        long t_comienzo, t_fin;
        t_comienzo = System.currentTimeMillis();
        int cantidad = 0;
        FileReader lector = null;
        try {
            lector = new FileReader(documento);

            for(int i =0; i<documento.length(); i++){
                //System.out.println((char)lector.read());
                if((char)lector.read() != ' '){
                    cantidad++;
                }
            }
            System.out.println("Total: "+cantidad);
            t_fin = System.currentTimeMillis();
            long tiempototal = t_fin - t_comienzo;
            System.out.println("El hilo "+Thread.currentThread().getId()+" ha tardado: " + tiempototal + "milisegundos");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {

        for(String argumento : args){
            //Cada argumento será un fichero
            Aprendizaje3 hilo = new Aprendizaje3(new File("./src/unidad2/"+argumento));
            hilo.start();
        }
    }


}
