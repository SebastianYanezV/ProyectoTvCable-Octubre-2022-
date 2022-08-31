package proyectotvcable;

import java.io.*;
import java.util.*;

public class ProyectoTvCable
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        // TODO code application logic here
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Empresa> mapaEmpresas = new HashMap<>();
        llenadoDeDatos(mapaEmpresas);
    }

    public static void llenadoDeDatos(HashMap<String, Empresa> mapaEmpresas) throws IOException
    {
        Empresa compania = new Empresa("Claro");
        PlanEmpresa plan = new PlanEmpresa(1, 10000, 4);
        compania.addPlan(compania.getListaPlanes(), plan);
        mapaEmpresas.put(compania.getNombre(), compania);
        compania = new Empresa("Entel");
        mapaEmpresas.put(compania.getNombre(), compania);
        compania = new Empresa("Movistar");
        mapaEmpresas.put(compania.getNombre(), compania);
        compania = new Empresa("WOM");
        mapaEmpresas.put(compania.getNombre(), compania);
        compania = new Empresa("VTR");
        mapaEmpresas.put(compania.getNombre(), compania);
        System.out.println(mapaEmpresas.get("Claro").getListaPlanes().get(0).getPrecio());

        for (String i : mapaEmpresas.keySet())
        {
            System.out.println("Empresa: " + i);
        }
    }
}