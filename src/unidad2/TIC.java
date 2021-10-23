package unidad2;

public class TIC extends Thread {
    public TIC(){

    }
    public void run(){
        for(;;){
            System.out.println("TIC");
            try {
                sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
