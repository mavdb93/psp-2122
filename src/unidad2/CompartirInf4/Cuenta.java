package unidad2.CompartirInf4;

public class Cuenta {
    private int saldo;
    Cuenta(int saldo){
        this.saldo = saldo;
    }
    public int getSaldo(){
        return this.saldo;
    }
    public void restar(int cantidad){
        this.saldo=this.saldo-cantidad;
    }
    synchronized public void retirarDinero(int cantidad, String nom){
        if(getSaldo() >= cantidad){
            System.out.println(nom + ": SE VA A RETIRAR SALDO (ACTUAL ES: "+ getSaldo()+")");
            try{
                Thread.sleep(500);
            }catch(InterruptedException ie){}
            restar(cantidad);
            System.out.println("\t"+nom+" retira => "+cantidad+" (ACTUAL ES: "+ getSaldo()+")");
        }else{
            System.out.println("NO SE PUDO RETIRAR DINERO, NO HAY SALDO ("+getSaldo()+")");
        }

        if(getSaldo()<0){
            System.out.println("SALDO NEGATIVO => " + getSaldo());
        }
    }
}
