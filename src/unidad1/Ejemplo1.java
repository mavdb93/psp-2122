package unidad1;
public class Ejemplo1 {
    public static void main(String[] args){
        try{
            Process pb = new ProcessBuilder("gedit").start();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
