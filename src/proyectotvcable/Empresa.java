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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<PlanEmpresa> getListaPlanes() {
        ArrayList<PlanEmpresa> a = listaPlanes;
        return a;
    }

    public void addPlan(PlanEmpresa plan){
        listaPlanes.add(plan);
    }

    public ArrayList<PlanEmpresa> buscarPlan(double val){
        ArrayList<PlanEmpresa> a = new ArrayList<>();
        for (PlanEmpresa plan : listaPlanes) {
            if (plan.getValoracion() >= val) {
                a.add(plan);
            }
        }
        if (a.isEmpty()) return null;
        return a;
    }

    public ArrayList<PlanEmpresa> buscarPlan(int precio){
        ArrayList<PlanEmpresa> a = new ArrayList<>();
        for (PlanEmpresa plan : listaPlanes) {
            if (plan.getPrecio() <= precio) {
                a.add(plan);
            }
        }
        if (a.isEmpty()) return null;
        return a;
    }

    public PlanEmpresa buscarPlan(byte id){
        for (PlanEmpresa plan : listaPlanes) {
            if (plan.getId() == id) {
                return plan;
            }
        }
        return null;
    }

    public PlanEmpresa buscarPlan(String nombre){
        for (PlanEmpresa plan : listaPlanes) {
            if (plan.getNombre().equals(nombre)) {
                return plan;
            }
        }
        return null;
    }
}
