package unidad3.Hilos_Compartiendo_Objetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class JugadorAdivina {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String host ="localhost";
        int puerto = 6001;
        Socket cliente = new Socket(host,puerto);
        ObjectOutputStream flujoSalida = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());

        //FLUJO PARA ENTRADA ESTANDARD
        Scanner entradaDatos = new Scanner(System.in);
        String cadena = "";

        //OBTENEMOS EL PRIMER OBJETO ENVIADO POR EL SERVIDOR
        Datos datos = (Datos)flujoEntrada.readObject();
        int id= datos.getIdentificador();
        System.out.println("ID del jugador: "+id);
        System.out.println(datos.getCadena());

        if(!datos.isJuega()){
            //Si el juego ha muerto
            cadena="*";
        }
        while(datos.isJuega() && !cadena.trim().equals("*")){
            //Mientras el juego siga existiendo y no se pase *
            System.out.println("Intento nº: "+(datos.getIntentos()+1)+" =>Introduce número:");
            cadena = entradaDatos.nextLine();
            Datos d = new Datos();
            if(!validarCadena(cadena)) continue;
            d.setCadena(cadena);

            //ENVIAMOS DATOS AL SERVIDOR, EL NÚMERO LEIDO POR TECLADO.
            flujoSalida.reset();
            flujoSalida.writeObject(d);

            //RECIBIMOS DATOS DLE SERVIDOR

            datos = (Datos) flujoEntrada.readObject();
            //System.out.println("\t"+datos.getCadena());
            if(datos.getIntentos()>=5){
                System.out.println("\t<<JUEGO FINALIZADO, NO HAY MAS INTENTOS>>");
                cadena ="*";
            }
            if(datos.isGana()){
                System.out.println("Has ganado el juego");
                cadena ="*";
            }else{
                if(!(datos.isJuega())){
                    System.out.println(" EL JUEGO HA ACABADO PORQUE SE HA ADIVINADO EL NÚMERO");
                    cadena = "*";
                }
            }


        }
        flujoSalida.close();
        flujoEntrada.close();
        entradaDatos.close();
        cliente.close();
        System.out.println("FIN DLE PROCESO....");

    }
    private static boolean validarCadena(String cadena){
        boolean valor = false;
        try{
            Integer.parseInt(cadena);
            valor = true;
        }catch (NumberFormatException nfe){}
        return valor;
    }


}
