package unidad1.aprendizaje;

public class CincoVeces {
    public static void main(String[] args) {
        String argumentosLeidos = "";
        int repeticiones = 5;
        for (int i = 0; i < args.length; i++) {
            argumentosLeidos += " " + args[i];
        }
        argumentosLeidos = argumentosLeidos.trim();
        if (argumentosLeidos.length() == 0) {
            System.out.println("No se han recibido argumentos. Procedemos a cerrar el programa");
            System.exit(1);
        }else{
            for (int i = 0; i < repeticiones; i++) {
                System.out.println(argumentosLeidos);

            }
        }
    }
}
