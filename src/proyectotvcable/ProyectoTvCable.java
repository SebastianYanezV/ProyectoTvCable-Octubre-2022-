/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotvcable;

/**
 *
 * @author pipez
 *
 */
import java.io.*;
import java.util.*;
public class ProyectoTvCable {
    public static void main(String[] args) throws IOException{
        //BufferedReader lector= new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Empresa> empresas=new ArrayList<>();
        llenarInicial(empresas);
        
        /*
        int opcion;
        boolean salir=false;
        while(!salir)
        {
            System.out.println("A continuacion se presentaran todas las empresas disponibles:");
            opcion=Integer.parseInt(lector.readLine());
            switch(opcion)
            {
                case 1:
                {
                    break;
                }
            }
        }*/
    }  
    
    public static void llenarInicial(ArrayList<Empresa> empresas) throws IOException
    {
        ArrayList<PlanEmpresa> plan1=new ArrayList<>();
        llenarPlan(plan1);
        Empresa empresa=new Empresa("claro",plan1);
        empresas.add(empresa);
        for (int i = 0; i<empresas.size(); i++)
        {
            Empresa empresa1 = empresas.get(i);
            System.out.println("nombre empresa"+ empresa1.getNombre());
        }
        
    }
    
    public static void llenarPlan(ArrayList<PlanEmpresa> plan) throws IOException
    {
        BufferedReader lector= new BufferedReader(new InputStreamReader(System.in));
        int id=Integer.parseInt(lector.readLine());
        int precio=Integer.parseInt(lector.readLine());
        double valoracion=Double.parseDouble(lector.readLine());
        String[] canales = new String[5];
        int i;
        for(i=0;i<canales.length;i++)
        {
            canales[i]=lector.readLine();
        }
        PlanEmpresa pp=new PlanEmpresa(id,precio,valoracion,canales);
        plan.add(pp);
    }
}

class Empresa{
    private String nombre;
    private ArrayList<PlanEmpresa> planes;
    public Empresa(String nombre,ArrayList<PlanEmpresa> planes)
    {
        this.nombre=nombre;
        this.planes=new ArrayList<>();
        this.planes.addAll(planes);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarPlan(PlanEmpresa plan)
    {
        int i;
        for(i=0;i<planes.size();i++)
        {
            int id=planes.get(i).getId();
            /*if(plan.getId().equal(id))
            {
                System.out.println("Ya existe el plan");
                return;
            }*/
        }
        planes.add(plan);
    }
}

class PlanEmpresa{
    private int id;
    private int precio;
    private double valoracion;
    private String[] canales;
    
    public PlanEmpresa(int id,int precio,double valoracion,String[] canales)
    {
        this.id=id;
        this.precio=precio;
        this.valoracion=valoracion;
        this.canales=canales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    public String[] getCanales() {
        return canales;
    }

    public void setCanales(String[] canales) {
        this.canales = canales;
    }
}