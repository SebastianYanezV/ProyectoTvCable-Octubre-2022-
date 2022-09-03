package proyectotvcable;

import java.io.*;
import java.util.*;

public class ProyectoTvCable
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Se crea el mapa que almacenara las empresas del programa (clave: nombre de la empresa, valor: la empresa)
        HashMap<String, Empresa> mapaEmpresas = new HashMap<>();
        llenadoDeDatos(mapaEmpresas);
        menuInicial(mapaEmpresas);
    }

    public static void llenadoDeDatos(HashMap<String, Empresa> mapaEmpresas)
    {
        //Se hace un llenado de datos inicial, se crean 5 empresas, cada una con un plan disponible
        byte id = 1;
        Empresa compania = new Empresa();
        compania.setNombre("Claro");
        PlanEmpresa plan = new PlanEmpresa(id, "Basico", 10000, 4);
        compania.addPlan(plan);
        mapaEmpresas.put(compania.getNombre(), compania);
        compania = new Empresa();
        compania.setNombre("Entel");
        plan = new PlanEmpresa(id, "Basico",10000, 4);
        compania.addPlan(plan);
        mapaEmpresas.put(compania.getNombre(), compania);
        compania = new Empresa();
        compania.setNombre("Movistar");
        plan = new PlanEmpresa(id, "Basico",10000, 4);
        compania.addPlan(plan);
        mapaEmpresas.put(compania.getNombre(), compania);
        compania = new Empresa();
        compania.setNombre("WOM");
        plan = new PlanEmpresa(id, "Basico",10000, 4);
        compania.addPlan(plan);
        mapaEmpresas.put(compania.getNombre(), compania);
        compania = new Empresa();
        compania.setNombre("VTR");
        plan = new PlanEmpresa(id, "Basico",10000, 4);
        compania.addPlan(plan);
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
                case 1 -> {
                    listarEmpresas(mapaEmpresas);
                    System.out.println("Ingrese el nombre de la empresa a la que quiere acceder");
                    String nombre = lector.readLine();
                    Empresa emp = mapaEmpresas.get(nombre);

                    if (emp != null){
                        menuEmpresa(emp, lector);
                    }
                    else{
                        System.out.println("El nombre de esta empresa no se encuentra en nuestros registros.");
                        do{
                            System.out.println("Ingrese el nombre de la empresa a la que quiere acceder");
                            nombre = lector.readLine();
                            emp = mapaEmpresas.get(nombre);
                        } while (emp == null);
                        menuEmpresa(emp, lector);
                    }
                }
                case 2 -> salir = true;
                default -> System.out.println("Numero fuera de rango, intente de nuevo.");
            }
        }
    }

    public static void menuEmpresa(Empresa empresa, BufferedReader lector) throws IOException
    {
        int opcion;
        while(true)
        {
            System.out.println("1.Ver planes");
            System.out.println("2.Buscar plan");
            System.out.println("3.Agregar plan");
            System.out.println("4.Salir");
            opcion = Integer.parseInt(lector.readLine());
            switch (opcion)
            {
                case 1 -> listarPlanes(empresa.getListaPlanes());
                case 2 -> menuPlanes(empresa, lector);
                case 3 -> agregarPlan(empresa, lector);
                case 4 -> {return;}
                default -> System.out.println("Numero fuera de rango, intente de nuevo.");
            }
        }
    }

    public static void menuPlanes(Empresa empresa, BufferedReader lector) throws IOException
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
                    byte id = Byte.parseByte(lector.readLine());
                    printPlan(empresa.buscarPlan(id));
                }
                case 2 -> {
                    System.out.println("Ingrese el nombre a buscar:");
                    String nombre = lector.readLine();
                    printPlan(empresa.buscarPlan(nombre));
                }
                case 3 -> {
                    System.out.println("Ingrese el precio maximo a buscar:");
                    opcion = Integer.parseInt(lector.readLine());
                    listarPlanes(empresa.buscarPlan(opcion));
                }
                case 4 -> {
                    System.out.println("Ingrese la valoracion maxima a buscar:");
                    double val = Double.parseDouble(lector.readLine());
                    listarPlanes(empresa.buscarPlan(val));
                }
                case 5 -> {
                    return;
                }
                default -> System.out.println("Numero fuera de rango, intente de nuevo.");
            }
        }
    }
    public static void listarEmpresas(HashMap<String, Empresa> mapa){
        int j = 1;
        for (String i : mapa.keySet())
        {
            System.out.println("Empresa "+ j++ + ": " + i);
        }
    }
    public static void listarPlanes(ArrayList<PlanEmpresa> array){
        if (array == null) {
            System.out.println("No se han encontrado planes con esos criterios.");
            return;
        }
        System.out.println("-----------------------------");
        for (PlanEmpresa plan : array)
        {
            System.out.println("ID Plan: " + plan.getId());
            System.out.println("Nombre Plan: " + plan.getNombre());
            System.out.println("Precio: " + plan.getPrecio());
            System.out.println("Valoracion de usuarios: " + plan.getValoracion());
            System.out.println("-----------------------------");
        }
    }
    public static void agregarPlan(Empresa empresa, BufferedReader lector) throws IOException{
        PlanEmpresa nuevoPlan = new PlanEmpresa();
        System.out.println("Ingrese el ID del plan a agregar:");
        byte id = Byte.parseByte(lector.readLine());
        for (PlanEmpresa plan : empresa.getListaPlanes()){
            if (plan.getId() == id){
                System.out.println("Ya existe un plan con este ID.");
                return;
            }
        }
        nuevoPlan.setId(id);
        System.out.println("Ingrese el nombre del plan a agregar:");
        nuevoPlan.setNombre(lector.readLine());
        System.out.println("Ingrese el precio del plan a agregar:");
        double precio = Double.parseDouble(lector.readLine());
        nuevoPlan.setPrecio(precio);
        nuevoPlan.setPrecio((int)precio);
        System.out.println("Ingrese la valoracion del plan a agregar:");
        nuevoPlan.setValoracion(Double.parseDouble(lector.readLine()));
        empresa.addPlan(nuevoPlan);
    }

    public static void printPlan(PlanEmpresa plan){
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