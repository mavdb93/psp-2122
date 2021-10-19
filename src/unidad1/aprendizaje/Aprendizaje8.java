package unidad1.aprendizaje;

import java.io.*;

public class Aprendizaje8 {
    //Realiza un programa Java que lea una cadena desde la entrada estándar y visualice en pantalla si la cadena es o no un palíndromo
    //o si la cadena está vacía (longitud 0).
    //Luego realiza un segundo programa Java que ejecute el anterior, debe leer la cadena desde teclado y mostrar la salida en pantalla.
    //Transforma este ejercicio para que la cadena se obtenga de un fichero de texto y se envíe la salida de error a otro fichero.

    public static void main(String[] args) throws IOException, InterruptedException {
        String ficheroEntrada;
        ficheroEntrada = args[0];

        // Como las utilidades y el ProcesadorFichero están en el mismo paquete podemos fundir
        // en una sola variable la ruta del classpath.
        /*String classpathUtilidades;
        classpathUtilidades = args[1];*/
       /* String classpathProcesadorFichero;
        classpathProcesadorFichero = args[2];*/

        String[] vocales = {"A", "E", "I", "O", "U"};
        String classPath;
        //classPath = classpathProcesadorFichero + ":" + classpathUtilidades;
        // Ponemos un único path porque tanto procesador como utilidades están en el mismo directorio.
        classPath = args[1];
        System.out.println("Usando classpath:" + classPath);

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);

        }
        /* Se lanzan los procesos*/
        for (int i = 0; i < vocales.length; i++) {
            String fichErrores = "Errores_" + vocales[i] + ".txt";
            ProcessBuilder pb;
            pb = new ProcessBuilder("java", "-cp", classPath, "unidad1.aprendizaje.ProcesadorFichero", ficheroEntrada, vocales[i], vocales[i] + ".txt");

            //Si hay algún error, almacenarlo en un fichero
            pb.redirectError(new File(fichErrores));
            Process p = pb.start();
            // Además de guardar en un fichero de errores se muestran estos en pantalla.
            try {
                System.out.println("ERRORES de " + vocales[i]);
                InputStream er = p.getErrorStream();
                BufferedReader brer = new BufferedReader(new InputStreamReader(er));
                String liner = null;
                while ((liner = brer.readLine()) != null)
                    System.out.println("ERROR >" + liner);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            //Fin del for
        }
        /* Esperamos un poco*/
        Thread.sleep(3000);
        /* La recogida de resultados se deja como
         * ejercicio al lector. ;) */
        int totalvocales = 0;
        for (int i = 0; i < vocales.length; i++) {
            BufferedReader br;
            br = UtilidadesFicheros.getBufferedReader(vocales[i] + ".txt");
            // el fichero sólo contiene una línea con el total de vocales de una determinada letra
            totalvocales += Integer.parseInt(br.readLine());  // convertir la cadena leída en un valor entero.
        }
    }
}