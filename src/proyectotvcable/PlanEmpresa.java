package proyectotvcable;

public class PlanEmpresa
{
    private byte id;
    private String nombre;
    private int precio;
    private double valoracion;

    //Constructor con parametros (para el llenado inicial)
    public PlanEmpresa(byte id, String nombre, int precio, double valoracion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.valoracion = valoracion;
    }

    //Constructor sin parametros (para el llenado por consola)
    public PlanEmpresa(){}

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setPrecio(double precio){
        this.precio = (int) precio;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }
}