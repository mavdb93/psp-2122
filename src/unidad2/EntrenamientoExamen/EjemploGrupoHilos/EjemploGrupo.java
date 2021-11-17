package unidad2.EntrenamientoExamen.EjemploGrupoHilos;

public class EjemploGrupo extends Thread{

    @Override
    public void run() {
        System.out.println("Informacion del hilo: "+ currentThread().toString());
        for(int i = 0; i<1000; i++);
        System.out.println(Thread.currentThread().getName()+" Finalziando su ejecución.");
    }

    public static void main(String[] args) {
        Thread.currentThread().setName("Principal");
        System.out.println(Thread.currentThread().getName());
        //Con toString nos dice el Nombre, Prioridad y Grupo del hilo.
        System.out.println(Thread.currentThread().toString());

        ThreadGroup grupoHilos = new ThreadGroup("Grupo de hilos");
        EjemploGrupo h = new EjemploGrupo();
        //Para asignar grupos: Primero se pasa el grupo, luego el tipo de hilo y luego el nombre del hilo.
        Thread h1 = new Thread(grupoHilos,h,"Hilo 1");
        Thread h2 = new Thread(grupoHilos,h,"Hilo 2");
        Thread h3 = new Thread(grupoHilos,h,"Hilo 3");
        //Realmente se estan creando 4 hilos. El principal y 3 hilos ejecutados por el principal. Por defecto el principal esta dento del grupo MAIN.
        h1.start();
        h2.start();
        h3.start();

        System.out.println("SE HAN CREADO 3 HILOS...");
        System.out.println("Hilos activos: "+Thread.activeCount());
    }
}
