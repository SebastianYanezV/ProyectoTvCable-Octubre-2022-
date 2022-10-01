package proyectotvcable;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListaPlanes {
    private ArrayList<PlanEmpresa> listaPlanes;

    public ListaPlanes(){
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

    public void menuBusquedaPlanes(BufferedReader lector) throws IOException
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
                    try{
                        opcion = Integer.parseInt(lector.readLine());
                        listarPlanes(buscarPlan(opcion));
                    }catch (NumberFormatException e){
                        System.out.println("Tipo de dato equivocado.");
                    }
                }
                case 4 -> {
                    System.out.println("Ingrese la valoracion maxima a buscar:");
                    try{
                        double val = Double.parseDouble(lector.readLine());
                        listarPlanes(buscarPlan(val));
                    }catch (NumberFormatException e){
                        System.out.println("Tipo de dato equivocado.");
                    }
                }
                case 5 -> {
                    return;
                }
            }
        }
    }

    public void menuEliminarPlanes(BufferedReader lector) throws IOException
    {
        int opcion;
        while(true)
        {
            System.out.println("Por que parametro desea buscar para eliminar?");
            System.out.println("1.Buscar por ID");
            System.out.println("2.Buscar por nombre");
            System.out.println("3.Salir");
            opcion = Integer.parseInt(lector.readLine());
            switch (opcion)
            {
                case 1 -> {
                    System.out.println("Ingrese el ID a eliminar:");
                    try{
                        byte id = Byte.parseByte(lector.readLine());
                        eliminarPlan(id);
                    }catch (NumberFormatException e){
                        System.out.println("Tipo de dato equivocado.");
                    }
                }
                case 2 -> {
                    System.out.println("Ingrese el nombre a eliminar:");
                    String nombre = lector.readLine();
                    eliminarPlan(nombre);
                }
                case 3 -> {
                    return;
                }
            }
        }
    }

    public void menuModificarPlanes(BufferedReader lector) throws IOException
    {
        int opcion;
        while(true)
        {
            System.out.println("Por que parametro desea buscar para modificar?");
            System.out.println("1.Buscar por ID");
            System.out.println("2.Buscar por nombre");
            System.out.println("3.Salir");
            opcion = Integer.parseInt(lector.readLine());
            switch (opcion)
            {
                case 1 -> {
                    System.out.println("Ingrese el ID del plan a modificar:");
                    try{
                        byte id = Byte.parseByte(lector.readLine());
                        PlanEmpresa plan = buscarPlan(id);
                        modificarPlan(plan, lector);
                    }catch (NumberFormatException e){
                        System.out.println("Tipo de dato equivocado.");
                    }catch (NullPointerException e){
                        System.out.println("No se encontro un plan con el ID entregado");
                    }
                }
                case 2 -> {
                    System.out.println("Ingrese el nombre a eliminar:");
                    try{
                        String nombre = lector.readLine();
                        PlanEmpresa plan = buscarPlan(nombre);
                        modificarPlan(plan, lector);
                    }catch (NullPointerException e){
                        System.out.println("No se encontro un plan con ese nombre.");
                    }
                }
                case 3 -> {
                    return;
                }
            }
        }
    }

    public void modificarPlan(PlanEmpresa plan, BufferedReader lector) throws IOException{
        {
            int opcion;
            while(true)
            {
                System.out.println("Que desea modificar?");
                System.out.println("1.ID");
                System.out.println("2.Nombre");
                System.out.println("3.Precio");
                System.out.println("4.Valoracion");
                System.out.println("5.Salir");
                opcion = Integer.parseInt(lector.readLine());
                switch (opcion)
                {
                    case 1 -> {
                        System.out.println("Ingrese el ID nuevo para el plan:");
                        try{
                            plan.setId(Byte.parseByte(lector.readLine()));
                        }catch (NumberFormatException e){
                            System.out.println("NaN, input no aceptado.");
                        }
                    }
                    case 2 -> {
                        System.out.println("Ingrese el nombre nuevo para el plan:");
                        plan.setNombre(lector.readLine());
                    }
                    case 3 -> {
                        System.out.println("Ingrese el precio nuevo para el plan:");
                        try{
                            plan.setPrecio(Integer.parseInt(lector.readLine()));
                        }catch (NumberFormatException e){
                            System.out.println("NaN, input no aceptado.");
                        }
                    }
                    case 4 -> {
                        System.out.println("Ingrese la valoracion nueva para el plan:");
                        try{
                            plan.setValoracion(Double.parseDouble(lector.readLine()));
                        }catch (NumberFormatException e){
                            System.out.println("NaN, input no aceptado.");
                        }
                    }
                    case 5 -> {
                        return;
                    }
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
            System.out.println("-----------------------------");
            if (plan.getClass().getSimpleName().equals("PlanCable")){
                PlanCable planAux = (PlanCable) plan;
                planAux.getPlan();
                System.out.println("-----------------------------");
            }else if (plan.getClass().getSimpleName().equals("PlanTelefonia")){
                PlanTelefonia planAux = (PlanTelefonia) plan;
                planAux.getPlan();
                System.out.println("-----------------------------");
            }
        }
    }

    public void agregarPlan(BufferedReader lector) throws IOException, IDAlreadyInUseException {
        System.out.println("Ingrese el ID del plan a agregar:");
        byte id = Byte.parseByte(lector.readLine());
        for (PlanEmpresa plan : this.listaPlanes){
            if (plan.getId() == id){
                throw new IDAlreadyInUseException();
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

    public void eliminarPlan(byte id){
        PlanEmpresa plan = buscarPlan(id);
        if (plan != null){
            listaPlanes.remove(plan);
            System.out.println("Plan con ID " + id + " eliminado correctamente.");
        }
        else{
            System.out.println("No se encontro un plan con el ID especificado.");
        }
    }

    public void eliminarPlan(String nombre){
        PlanEmpresa plan = buscarPlan(nombre);
        if (plan != null){
            listaPlanes.remove(plan);
            System.out.println("Plan " + nombre + " eliminado correctamente.");
        }
        else{
            System.out.println("No se encontro un plan con el nombre especificado.");
        }
    }
}
