package unidad3.Hilos_Compartiendo_Objetos;

public class ObjetoQueSeComparte {
    private int numero;
    private boolean seHaAcabado;
    private int idGanador;

    public ObjetoQueSeComparte(int numero){
        //Número que hay que adivinar
        this.numero = numero;
        //Al iniciciarse el objeto no puede haber acabado el juego ni existir ganador.
        this.seHaAcabado = false;
    }
    public synchronized String nuevaJugada(int idJugador, int numeroEscritoPorJugador){
        String cadena = "";
        //Solo se ejecutará si el jeugo no ha acabado.
        if(!seAcabo()){
            if(numeroEscritoPorJugador > this.numero){
                cadena = "El número que ha escrito el jugador " + idJugador + " es demasiado grande.";
            }
            if(numeroEscritoPorJugador < this.numero){
                cadena = "El número que ha escrito el jugador " + idJugador + " es demasiado bajo.";
            }
            if(numeroEscritoPorJugador == this.numero){
                cadena = "El jugador " + idJugador + " ha adivinado el número.";
                seHaAcabado = true;
                idGanador = idJugador;
            }
        }else{
            //Si el juego ya ha terminado:
            System.out.println("El jugador con ID: " + idJugador+" ha adivinado el número "+this.numero);
        }
        //devolvemos la cadena resultado.
        return cadena;
    }

    public boolean seAcabo(){
        return this.seHaAcabado;
    }
    public int getIdGanador(){
        return this.idGanador;
    }
}
