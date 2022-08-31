package proyectotvcable;

import java.util.*;

public class Empresa
{
    private String nombre;
    private ArrayList<PlanEmpresa> listaPlanes;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.listaPlanes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<PlanEmpresa> getListaPlanes() {
        return listaPlanes;
    }

    public void addPlan(ArrayList<PlanEmpresa> array, PlanEmpresa plan){
        array.add(plan);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
