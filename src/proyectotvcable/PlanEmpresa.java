package proyectotvcable;

import java.util.*;

public class PlanEmpresa
{
    private int id;
    private int precio;
    private double valoracion;
    private ArrayList<String> listaCanales;

    public PlanEmpresa(int id, int precio, double valoracion) {
        this.id = id;
        this.precio = precio;
        this.valoracion = valoracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }
}