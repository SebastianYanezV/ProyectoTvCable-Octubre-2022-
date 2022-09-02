package proyectotvcable;

import java.util.*;

public class Empresa
{
    private String nombre;

    //ArrayList con todos los planes de la empresa
    private ArrayList<PlanEmpresa> listaPlanes;

    /*public Empresa(String nombre) {
        this.nombre = nombre;
        this.listaPlanes = new ArrayList<>();
    }*/

    public Empresa() {
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

    //Se buscan los planes con cierto minimo de valoracion
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

    //Se buscan los planes con cierto maximo de valoracion
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

    //Se busca un plan con un ID especifico
    public PlanEmpresa buscarPlan(byte id){
        for (PlanEmpresa plan : listaPlanes) {
            if (plan.getId() == id) {
                return plan;
            }
        }
        return null;
    }

    //Se busca un plan con un nombre especifico
    public PlanEmpresa buscarPlan(String nombre){
        for (PlanEmpresa plan : listaPlanes) {
            if (plan.getNombre().equals(nombre)) {
                return plan;
            }
        }
        return null;
    }
}