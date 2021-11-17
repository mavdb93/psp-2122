package unidad2.Actividad2_10;

public class Cola {
    private int numero;
    //Establecemos nuestra variable bandera, que llamaremos "disponible"
    private boolean disponible = false;
    //Por defecto en la cola no hay número disponible, ya que se genera vacía.
    //De la cola se pueden sacar datos o introducir datos.
    //Ambos métodos deben ser syncrhonized para impedir que puedan ejecutarse a la vez.

    //Si la cola está vacia. Es decir, si no tiene datos disponibles
    //no podrá obtenerse datos, por lo que se mantendrá a la espera hasta que sea disponible.
    synchronized public int get(){
        //No es posible sacar datos
        if(!disponible){
            try{
                //Espera hasta notify
                wait();
            }catch(InterruptedException ie){}

        }
        //Si es posible sacar datos, por lo que lo sacamos.
        //Hacemos que no sea disponible sacar datos
        disponible = false;
        //Notificamos que se puede intentar SACAR o METER datos.
        this.notify();
        //Obtenemos el dato a sacar
        return numero;

    }
    //Si la cola esta vacía, se podran meter datos, si no no.
    synchronized public void put(int num){
        //Mientras haya datos en la cola, mantente a la espera hasta notifiy
        while(disponible){
            try{
                wait();
            }catch(InterruptedException ie){}

        }
        //Si no hay datos en la cola, establecemos el dato e informamos de que hay datos disponibles.
       this.numero = num;
       this.disponible = true;
        //Notificamos que se puede intentar SACAR o METER datos.
        this.notify();
    }
}
