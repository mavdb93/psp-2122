package unidad3;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) {
        InetAddress dir = null;
        System.out.println("===============================================");
        System.out.println("SALIDA PARA LOCALHOST: ");
        try{
            //LOCALHOST
            dir = InetAddress.getByName("localhost");
            pruebaMetodos(dir);
            //URL DE GOOGLE
            System.out.println("===============================================");
            System.out.println("SALIDA PARA UNA URL:");
            dir = InetAddress.getByName("www.google.es");
            pruebaMetodos(dir);

            System.out.println("\tDIRECCIONES IP PARA: " + dir.getHostName());
            InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
            for(int i =0; i< direcciones.length;i++){
                System.out.println("\t\t"+direcciones[i].toString());
            }
            System.out.println("===============================================");
        }catch(UnknownHostException uhe){
            System.out.println(uhe.getMessage());
        }
    }
    private static void pruebaMetodos(InetAddress dir){
        System.out.println("\tMetodo getByName(): " + dir);
        InetAddress dir2;
        try{
            dir2 = InetAddress.getLocalHost();
            System.out.println("\tMetodo getLocalHost(): "+dir2);
        }catch (UnknownHostException uhe){
            System.out.println(uhe.getMessage());
        }
        //USAMOS MÉTODOS DE LA CLASE
        System.out.println("\tMétodo getHostName(): "+dir.getHostName());
        System.out.println("\tMétodo getHostAddress(): "+dir.getHostAddress());
        System.out.println("\tMétodo toString(): "+dir.toString());
        System.out.println("\tMétodo getCanonicalHostName(): "+dir.getCanonicalHostName());
    }
}
