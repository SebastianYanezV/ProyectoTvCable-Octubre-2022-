package proyectotvcable;

import java.io.BufferedReader;
import java.io.IOException;

public class Empresa {
    private String nombre;
    private listaPlanes planes;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.planes = new listaPlanes();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public listaPlanes getPlanes(){
        return planes;
    }

    public void menuEmpresa(BufferedReader lector) throws IOException
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
                case 1 -> getPlanes().listarPlanes(planes.getListaPlanes());
                case 2 -> getPlanes().menuPlanes(lector);
                case 3 -> getPlanes().agregarPlan(lector);
                case 4 -> {return;}
                default -> System.out.println("Numero fuera de rango, intente de nuevo.");
            }
        }
    }
}
