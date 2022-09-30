package proyectotvcable;

import java.util.HashMap;

public class mapaEmpresas {
    private HashMap<String, Empresa> mapaEmpresas;

    public mapaEmpresas(){
        this.mapaEmpresas = new HashMap<>();
    }

    public HashMap<String, Empresa> getMapa(){
        HashMap<String, Empresa> m = mapaEmpresas;
        return m;
    }

    public void llenadoDeDatos()
    {
        byte id = 1;
        Empresa compania = new Empresa("Claro");
        PlanEmpresa plan = new PlanEmpresa(id, "Basico", 10000, 4);
        compania.getPlanes().addPlan(plan);
        mapaEmpresas.put(compania.getNombre(), compania);
        compania = new Empresa("Entel");
        plan = new PlanEmpresa(id, "Basico",10000, 4);
        compania.getPlanes().addPlan(plan);
        mapaEmpresas.put(compania.getNombre(), compania);
        compania = new Empresa("Movistar");
        plan = new PlanEmpresa(id, "Basico",10000, 4);
        compania.getPlanes().addPlan(plan);
        mapaEmpresas.put(compania.getNombre(), compania);
        compania = new Empresa("WOM");
        plan = new PlanEmpresa(id, "Basico",10000, 4);
        compania.getPlanes().addPlan(plan);
        mapaEmpresas.put(compania.getNombre(), compania);
        compania = new Empresa("VTR");
        plan = new PlanEmpresa(id, "Basico",10000, 4);
        compania.getPlanes().addPlan(plan);
        mapaEmpresas.put(compania.getNombre(), compania);
    }

    public void listarEmpresas(){
        int j = 1;
        for (String i : this.mapaEmpresas.keySet())
        {
            System.out.println("Empresa "+ j++ + ": " + i);
        }
    }


}
