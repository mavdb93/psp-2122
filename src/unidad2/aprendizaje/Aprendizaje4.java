package unidad2.aprendizaje;

import java.io.*;

public class Aprendizaje4 extends Thread{
    /*
    Haz un programa Java que reciba a través de sus argumentos una lista de ficheros de texto y que cuente el número de palabras que hay en cada fichero.
    Se debe crear un hilo por cada fichero a contar. Muestra el número de palabras de cada fichero y lo que tarda en contar las palabras.
    */
    //Leemos el argumento:
    File documento;
    public Aprendizaje4(File documento){
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
                if((char)lector.read()==' '){
                    cantidad++;
                }else if(i==0 && (char)lector.read()!=' '){
                    cantidad++;
                }
            }
            System.out.println("Total del hilo " + Thread.currentThread().getId() + ": "+cantidad);
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
            Aprendizaje4 hilo = new Aprendizaje4(new File("./src/unidad2/"+argumento));
            hilo.start();
        }
    }


}
