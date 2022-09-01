package proyectotvcable;

import java.io.*;
import java.util.*;

public class ProyectoTvCable
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        //
        HashMap<String, Empresa> mapaEmpresas = new HashMap<>();
        llenadoDeDatos(mapaEmpresas);
        menuInicial(mapaEmpresas);
    }

    public static void llenadoDeDatos(HashMap<String, Empresa> mapaEmpresas)
    {
        Empresa compania = new Empresa("Claro");
        PlanEmpresa plan = new PlanEmpresa(1, 10000, 4);
        compania.addPlan(compania.getListaPlanes(), plan);
        mapaEmpresas.put(compania.getNombre(), compania);
        compania = new Empresa("Entel");
        plan = new PlanEmpresa(1, 10000, 4);
        compania.addPlan(compania.getListaPlanes(), plan);
        mapaEmpresas.put(compania.getNombre(), compania);
        compania = new Empresa("Movistar");
        plan = new PlanEmpresa(1, 10000, 4);
        compania.addPlan(compania.getListaPlanes(), plan);
        mapaEmpresas.put(compania.getNombre(), compania);
        compania = new Empresa("WOM");
        plan = new PlanEmpresa(1, 10000, 4);
        compania.addPlan(compania.getListaPlanes(), plan);
        mapaEmpresas.put(compania.getNombre(), compania);
        compania = new Empresa("VTR");
        plan = new PlanEmpresa(1, 10000, 4);
        compania.addPlan(compania.getListaPlanes(), plan);
        mapaEmpresas.put(compania.getNombre(), compania);
    }

    public static void menuInicial(HashMap<String, Empresa> mapaEmpresas) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println("1.Empresas");
            System.out.println("2.Salir");
            opcion = Integer.parseInt(lector.readLine());
            switch (opcion) {
                case 1:
                    listarEmpresas(mapaEmpresas);
                    System.out.println("Ingrese el nombre de la empresa a la que quiere acceder");
                    String nombre = lector.readLine();
                    Empresa emp = mapaEmpresas.get(nombre);
                    menuEmpresa(emp, lector);
                    break;
                case 2:
                    salir = true;
                    break;
            }
        }
    }

    public static void menuEmpresa(Empresa empresa, BufferedReader lector) throws IOException
    {
        int opcion;
        boolean salir = false;

        while(!salir)
        {
            System.out.println("1.Ver planes");
            System.out.println("2.Buscar plan");
            System.out.println("3.Agregar plan");
            System.out.println("4.Salir");

            opcion = Integer.parseInt(lector.readLine());

            switch(opcion)
            {
                case 1:
                    listarPlanes(empresa.getListaPlanes());
                    break;
                case 2:
                    //a();
                    break;
                case 3:
                    agregarPlan(empresa, lector);
                    break;
                case 4:
                    return;
            }
        }
    }
    public static void listarEmpresas(HashMap<String, Empresa> mapa){
        int j = 0;
        for (String i : mapa.keySet())
        {
            j++;
            System.out.println("Empresa "+ j + ": " + i);
        }
    }
    public static void listarPlanes(ArrayList<PlanEmpresa> array){
        for (PlanEmpresa plan : array)
        {
            System.out.println("ID Plan: " + plan.getId());
            System.out.println("Precio: " + plan.getPrecio());
            System.out.println("Valoracion de usuarios: " + plan.getValoracion());
            System.out.println("-----------------------------");
        }
    }

    public static void agregarPlan(Empresa empresa, BufferedReader lector) throws IOException{
        System.out.println("Ingrese el ID del plan a agregar:");
        int id = Integer.parseInt(lector.readLine());
        for (PlanEmpresa plan : empresa.getListaPlanes()){
            if (plan.getId() == id){
                System.out.println("Ya existe un plan con este ID.");
                return;
            }
        }
        System.out.println("Ingrese el precio del plan a agregar:");
        int precio = Integer.parseInt(lector.readLine());
        System.out.println("Ingrese la valoracion del plan a agregar:");
        double val = Double.parseDouble(lector.readLine());
        empresa.addPlan(empresa.getListaPlanes(), id, precio, val);
    }
}