package unidad2;

public class TAC extends Thread{
    public TAC(){

    }
    public void run(){
        for(;;){
            System.out.println("TAC");
            try {
                sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
