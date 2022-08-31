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
            System.out.println("Seleccione su destino:");
            System.out.println("1.Listar Empresas");
            System.out.println("0.Salir");
            opcion = Integer.parseInt(lector.readLine());
            switch (opcion) {
                case 1 -> listarEmpresas(mapaEmpresas);
                case 0 -> salir = true;
                default -> System.out.println("Fuera de rango, intente de nuevo.");
            }
        }
    }

    public static void listarEmpresas(HashMap<String, Empresa> mapa){
        for (String i : mapa.keySet())
        {
            System.out.println("Empresa: " + i);
        }
    }
}