package proyectotvcable;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class listaPlanes {
    private ArrayList<PlanEmpresa> listaPlanes;

    public listaPlanes(){
        this.listaPlanes = new ArrayList<>();
    }

    public ArrayList<PlanEmpresa> getListaPlanes() {
        ArrayList<PlanEmpresa> a = listaPlanes;
        return a;
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

    public void addPlan(PlanEmpresa plan) {
        listaPlanes.add(plan);
    }

    public void menuPlanes(BufferedReader lector) throws IOException
    {
        int opcion;
        while(true)
        {
            System.out.println("Por que parametro desea buscar?");
            System.out.println("1.Buscar por ID");
            System.out.println("2.Buscar por nombre");
            System.out.println("3.Buscar por precio");
            System.out.println("4.Buscar por valoracion");
            System.out.println("5.Salir");
            opcion = Integer.parseInt(lector.readLine());
            switch (opcion)
            {
                case 1 -> {
                    System.out.println("Ingrese el ID a buscar:");
                    try{
                        byte id = Byte.parseByte(lector.readLine());
                        printPlan(buscarPlan(id));
                    }catch (NumberFormatException e){
                        System.out.println("Tipo de dato equivocado.");
                    }
                }
                case 2 -> {
                    System.out.println("Ingrese el nombre a buscar:");
                    String nombre = lector.readLine();
                    printPlan(buscarPlan(nombre));
                }
                case 3 -> {
                    System.out.println("Ingrese el precio maximo a buscar:");
                    opcion = Integer.parseInt(lector.readLine());
                    listarPlanes(buscarPlan(opcion));
                }
                case 4 -> {
                    System.out.println("Ingrese la valoracion maxima a buscar:");
                    double val = Double.parseDouble(lector.readLine());
                    listarPlanes(buscarPlan(val));
                }
                case 5 -> {
                    return;
                }
            }
        }
    }

    public void listarPlanes(ArrayList<PlanEmpresa> a){
        if (a == null) {
            System.out.println("No se han encontrado planes con esos criterios.");
            return;
        }
        System.out.println("-----------------------------");
        for (PlanEmpresa plan : a)
        {
            System.out.println("ID Plan: " + plan.getId());
            System.out.println("Nombre Plan: " + plan.getNombre());
            System.out.println("Precio: " + plan.getPrecio());
            System.out.println("Valoracion de usuarios: " + plan.getValoracion());
            System.out.println("-----------------------------");
        }
    }

    public void agregarPlan(BufferedReader lector) throws IOException{
        System.out.println("Ingrese el ID del plan a agregar:");
        byte id = Byte.parseByte(lector.readLine());
        for (PlanEmpresa plan : this.listaPlanes){
            if (plan.getId() == id){
                System.out.println("Ya existe un plan con este ID.");
                return;
            }
        }
        System.out.println("Ingrese el nombre del plan a agregar:");
        String nombre = lector.readLine();
        System.out.println("Ingrese el precio del plan a agregar:");
        int precio = Integer.parseInt(lector.readLine());
        System.out.println("Ingrese la valoracion del plan a agregar:");
        double val = Double.parseDouble(lector.readLine());
        PlanEmpresa nuevoPlan = new PlanEmpresa(id, nombre, precio, val);
        addPlan(nuevoPlan);
    }

    public void printPlan(PlanEmpresa plan){
        if (plan == null){
            System.out.println("No existe un plan que cumpla con el parametro ingresado.");
            return;
        }
        System.out.println("-----------------------------");
        System.out.println("ID Plan: " + plan.getId());
        System.out.println("Nombre Plan: " + plan.getNombre());
        System.out.println("Precio: " + plan.getPrecio());
        System.out.println("Valoracion de usuarios: " + plan.getValoracion());
        System.out.println("-----------------------------");
    }
}
