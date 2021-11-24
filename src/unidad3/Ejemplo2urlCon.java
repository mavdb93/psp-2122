package unidad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Ejemplo2urlCon {
    public static void main(String[] args) {
        try{
            URL url = new URL("http://localhost/2021/verNombre/vernombre.php");
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
            String cadena = "nombre=Maria Jesús&apellidos=Ramos Martín";

            //ESCRIBIR EN LA URL
            PrintWriter salida = new PrintWriter(con.getOutputStream());
            salida.write(cadena);
            salida.close();

            //LEER DESDE LA URL
            BufferedReader entrada = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String cadenaRecibida;
            while((cadenaRecibida=entrada.readLine())!= null){
                System.out.println(cadenaRecibida);
            }
            entrada.close();
        }catch(MalformedURLException me){
            System.out.println(me.getMessage());
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}
