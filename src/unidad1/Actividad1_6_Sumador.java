package unidad1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

public class Actividad1_6_Sumador {
    public static void main(String[] args) throws IOException {
        InputStreamReader lector = new InputStreamReader(System.in);
        BufferedReader entradaDatos = new BufferedReader(lector);
        String texto;
        Double numeroA,numeroB;
        try {
            System.out.println("Primer número...");
            texto = entradaDatos.readLine();
            numeroA = Double.valueOf(texto);
            System.out.println(numeroA);
            System.out.println("Segundo número...");
            texto = entradaDatos.readLine();
            numeroB = Double.valueOf(texto);
            System.out.println(numeroB);
            System.out.println("La suma es: "+(numeroA+numeroB));
            lector.close();

        }catch(Exception e) {
            System.out.println(e.getMessage());

        }

    }
}
