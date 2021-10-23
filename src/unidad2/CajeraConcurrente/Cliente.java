package unidad2.CajeraConcurrente;

public class Cliente {
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCarroCompra(int[] carroCompra) {
        this.carroCompra = carroCompra;
    }

    private String nombre;
    private int[] carroCompra;

    public Cliente(String nombre, int[] carroCompra) {
        this.nombre = nombre;
        this.carroCompra = carroCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getCarroCompra(){
        return carroCompra;
    }
}
