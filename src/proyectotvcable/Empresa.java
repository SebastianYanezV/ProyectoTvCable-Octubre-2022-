package proyectotvcable;

import java.io.BufferedReader;
import java.io.IOException;

public class Empresa {
    private String nombre;
    private ListaPlanes planes; //Variable que maneja los planes de la empresa

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.planes = new ListaPlanes();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaPlanes getPlanes(){
        return planes;
    }

    //Menu en el que se aplican las distintas funcionalidades sobre la segunda coleccion anidada de objetos (planes)
    public void menuEmpresa(BufferedReader lector) throws IOException
    {
        int opcion;
        while(true)
        {
            System.out.println("1.Ver planes");
            System.out.println("2.Buscar plan");
            System.out.println("3.Agregar plan");
            System.out.println("4.Eliminar plan");
            System.out.println("5.Modificar plan");
            System.out.println("6.Salir");
            opcion = Integer.parseInt(lector.readLine());
            switch (opcion)
            {
                case 1 -> getPlanes().listarPlanes(planes.getListaPlanes());
                case 2 -> getPlanes().menuBusquedaPlanes(lector);
                case 3 -> {
                    try{
                        getPlanes().agregarPlan(lector);
                    }catch(IDAlreadyInUseException e){
                        System.out.println("Ocurrio un error: " + e.getMessage());
                    }
                }
                case 4 -> getPlanes().menuEliminarPlanes(lector);
                case 5 -> getPlanes().menuModificarPlanes(lector);
                case 6 -> {return;}
                default -> System.out.println("Numero fuera de rango, intente de nuevo.");
            }
        }
    }
}