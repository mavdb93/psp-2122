package unidad2.PingPong;

public class Cola {
    String valor;
    boolean disponible = false;

    synchronized public String getValor(){
        if(!disponible){
            try{
                wait();
            }catch(InterruptedException ie){}
        }
        disponible = false;
        notify();
        return this.valor;
    }

    synchronized public void setValor(String valorInsertado){
        if(disponible){
            try{
                wait();
            }catch(InterruptedException ie){}
        }
        disponible = true;
        this.valor = valorInsertado;
        notify();

    }
}
