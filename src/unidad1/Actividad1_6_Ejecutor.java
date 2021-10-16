package unidad1;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Actividad1_6_Ejecutor {

    public static void main(String[] args) throws IOException{
        try {
            double numeroA,numeroB;
            numeroA = 5;
            numeroB = 10;
            File directorio = new File("./out/production/psp-2122/");
            File archivoSalida = new File("salidaEjecutor.txt");
            File archivoError = new File("errorEjecutor.txt");
            ProcessBuilder constructor = new ProcessBuilder("java","unidad1.Actividad1_6_Sumador");
            constructor.directory(directorio);
            constructor.redirectOutput(archivoSalida);
            constructor.redirectError(archivoError);
            Process proceso = constructor.start();
            OutputStream flujoEscritura = proceso.getOutputStream();
            //Por cada string que quedamos escribir debermeos aguregar "\n" para hacer INTRO
            flujoEscritura.write((String.valueOf(numeroA)+"\n").getBytes());
            flujoEscritura.write((String.valueOf(numeroB)+"\n").getBytes());
            flujoEscritura.flush();

            //lectura
            InputStream flujoLectura = proceso.getInputStream();
            int letra;
            while((letra = flujoLectura.read()) != -1) {
                System.out.print((char)letra);
            }
            flujoLectura.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }

    }
}
