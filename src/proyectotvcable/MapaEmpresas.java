package proyectotvcable;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapaEmpresas {
    private HashMap<String, Empresa> mapaEmpresas;

    public MapaEmpresas(){
        this.mapaEmpresas = new HashMap<>();
    }

    public HashMap<String, Empresa> getMapa(){
        HashMap<String, Empresa> m = mapaEmpresas;
        return m;
    }

    //Funcion para mostrar todas las empresas disponibles en la aplicacion
    public void listarEmpresas(){
        int j = 1;
        for (String i : this.mapaEmpresas.keySet())
        {
            System.out.println("Empresa "+ j++ + ": " + i);
        }
    }

    //Funcion para importar un archivo. El usuario ingresa un archivo, si este no existe, se utiliza el predeterminado
    public void lecturaArchivo() throws IOException {
        BufferedReader lectorNombre = new BufferedReader(new InputStreamReader(System.in));
        String localDir = System.getProperty("user.dir");
        System.out.println("Ingrese nombre de archivo a importar (predeterminado: Planes.csv): ");
        File file = new File(localDir + "\\" + lectorNombre.readLine());
        try{
            BufferedReader lector = new BufferedReader((new FileReader(file)));
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                Empresa busqueda = this.mapaEmpresas.get(datos[0]);
                if (busqueda == null){
                    Empresa emp = new Empresa(datos[0]);
                    if (datos[5].equals("Telefonia")){
                        PlanEmpresa plan = new PlanTelefonia(Byte.parseByte(datos[1]), datos[2], Integer.parseInt(datos[3]), Double.parseDouble(datos[4]), Boolean.parseBoolean(datos[6]), Integer.parseInt(datos[7]));
                        emp.getPlanes().addPlan(plan);
                    }else if (datos[5].equals("Cable")){
                        PlanEmpresa plan = new PlanCable(Byte.parseByte(datos[1]), datos[2], Integer.parseInt(datos[3]), Double.parseDouble(datos[4]), Boolean.parseBoolean(datos[6]), Integer.parseInt(datos[7]));
                        emp.getPlanes().addPlan(plan);
                    }
                    this.mapaEmpresas.put(datos[0], emp);
                }
                else{
                    if (datos[5].equals("Telefonia")){
                        PlanEmpresa plan = new PlanTelefonia(Byte.parseByte(datos[1]), datos[2], Integer.parseInt(datos[3]), Double.parseDouble(datos[4]), Boolean.parseBoolean(datos[6]), Integer.parseInt(datos[7]));
                        busqueda.getPlanes().addPlan(plan);
                    }else if (datos[5].equals("Cable")){
                        PlanEmpresa plan = new PlanCable(Byte.parseByte(datos[1]), datos[2], Integer.parseInt(datos[3]), Double.parseDouble(datos[4]), Boolean.parseBoolean(datos[6]), Integer.parseInt(datos[7]));
                        busqueda.getPlanes().addPlan(plan);
                    }
                }
            }
            lector.close();
        }catch (FileNotFoundException e){
            System.out.println("Archivo no encontrado, intentando importar predeterminado");
            try{
                file = new File(localDir + "\\Planes.csv");
                BufferedReader lector = new BufferedReader((new FileReader(file)));
                String linea;
                while ((linea = lector.readLine()) != null) {
                    String[] datos = linea.split(",");
                    Empresa busqueda = this.mapaEmpresas.get(datos[0]);
                    if (busqueda == null){
                        Empresa emp = new Empresa(datos[0]);
                        if (datos[5].equals("Telefonia")){
                            PlanEmpresa plan = new PlanTelefonia(Byte.parseByte(datos[1]), datos[2], Integer.parseInt(datos[3]), Double.parseDouble(datos[4]), Boolean.parseBoolean(datos[6]), Integer.parseInt(datos[7]));
                            emp.getPlanes().addPlan(plan);
                        }else if (datos[5].equals("Cable")){
                            PlanEmpresa plan = new PlanCable(Byte.parseByte(datos[1]), datos[2], Integer.parseInt(datos[3]), Double.parseDouble(datos[4]), Boolean.parseBoolean(datos[6]), Integer.parseInt(datos[7]));
                            emp.getPlanes().addPlan(plan);
                        }
                        this.mapaEmpresas.put(datos[0], emp);
                    }
                    else{
                        if (datos[5].equals("Telefonia")){
                            PlanEmpresa plan = new PlanTelefonia(Byte.parseByte(datos[1]), datos[2], Integer.parseInt(datos[3]), Double.parseDouble(datos[4]), Boolean.parseBoolean(datos[6]), Integer.parseInt(datos[7]));
                            busqueda.getPlanes().addPlan(plan);
                        }else if (datos[5].equals("Cable")){
                            PlanEmpresa plan = new PlanCable(Byte.parseByte(datos[1]), datos[2], Integer.parseInt(datos[3]), Double.parseDouble(datos[4]), Boolean.parseBoolean(datos[6]), Integer.parseInt(datos[7]));
                            busqueda.getPlanes().addPlan(plan);
                        }
                    }
                }
                lector.close();
            }catch(FileNotFoundException ee){
                throw new DefaultFileMissingException();
            }
        }
    }

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    //Funcion para exportar los datos de la aplicacion a un archivo designado por el usuario
    public void exportarArchivo() throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese nombre del archivo al cual exportar: ");
        String nombreArchivo = lector.readLine() + ".csv";
        ArrayList<String[]> lineas = new ArrayList<>();
        ArrayList<Empresa> empresas = new ArrayList<>(this.mapaEmpresas.values());
        for (Empresa empresa : empresas) {
            for (int j = 0; j < empresa.getPlanes().getListaPlanes().size(); j++) {
                if (empresa.getPlanes().getListaPlanes().get(j).getClass().getSimpleName().equals("PlanTelefonia")) {
                    PlanTelefonia aux = (PlanTelefonia) empresa.getPlanes().getListaPlanes().get(j);
                    lineas.add(new String[]{empresa.getNombre(),
                            String.valueOf(aux.getId()),
                            aux.getNombre(),
                            String.valueOf(aux.getPrecio()),
                            String.valueOf(aux.getValoracion()),
                            "Telefonia",
                            String.valueOf(aux.isRoaming()),
                            String.valueOf(aux.getMinutos())
                    });
                } else if (empresa.getPlanes().getListaPlanes().get(j).getClass().getSimpleName().equals("PlanCable")) {
                    PlanCable aux = (PlanCable) empresa.getPlanes().getListaPlanes().get(j);
                    lineas.add(new String[]{empresa.getNombre(),
                            String.valueOf(aux.getId()),
                            aux.getNombre(),
                            String.valueOf(aux.getPrecio()),
                            String.valueOf(aux.getValoracion()),
                            "Cable",
                            String.valueOf(aux.isHd()),
                            String.valueOf(aux.getCanales())
                    });
                }
            }
        }
        File csv = new File(nombreArchivo);
        try(PrintWriter pw = new PrintWriter(csv)){
            lineas.stream().map(this::convertToCSV).forEach(pw::println);
        }
        assert(csv.exists());
    }

    public void exportarReporte() throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese nombre del archivo al cual exportar: ");
        String nombreArchivo = lector.readLine() + ".txt";
        ArrayList<Empresa> empresas = new ArrayList<>(this.mapaEmpresas.values());
        File txt = new File(nombreArchivo);
        PrintWriter print = new PrintWriter(txt);
        for (Empresa empresa : empresas){
            print.printf("Planes ");
            print.printf("%s" + ":" + "%n", empresa.getNombre());
            ArrayList<PlanEmpresa> planes = empresa.getPlanes().getListaPlanes();
            for (PlanEmpresa plan : planes){
                if (plan.getClass().getSimpleName().equals("PlanCable")){
                    PlanCable aux = (PlanCable) plan;
                    print.printf("Tipo Plan: Cable" + "%n");
                    print.printf("ID: " + "%s" + "%n", aux.getId());
                    print.printf("Nombre: " + "%s" + "%n", aux.getNombre());
                    print.printf("Precio: " + "%s" + "%n", aux.getPrecio());
                    print.printf("Valoracion: " + "%s" + "%n", aux.getValoracion());
                    if (aux.isHd()){
                        print.printf("Incluye Canales en HD " + "%n");
                    }else{
                        print.printf("No Incluye Canales en HD" + "%n");
                    }
                    print.printf("Cantidad de canales: " + "%s" + "%n", aux.getCanales());
                }else if (plan.getClass().getSimpleName().equals("PlanTelefonia")){
                    PlanTelefonia aux = (PlanTelefonia) plan;
                    print.printf("Tipo Plan: Telefonia" + "%n");
                    print.printf("ID: " + "%s" + "%n", aux.getId());
                    print.printf("Nombre: " + "%s" + "%n", aux.getNombre());
                    print.printf("Precio: " + "%s" + "%n", aux.getPrecio());
                    print.printf("Valoracion: " + "%s" + "%n", aux.getValoracion());
                    if (aux.isRoaming()){
                        print.printf("Incluye Roaming Ilimitado " + "%n");
                    }else{
                        print.printf("No Incluye Roaming Ilimitado" + "%n");
                    }
                    print.printf("Minutos: " + "%s" + "%n", aux.getMinutos());
                }
            }
            print.printf("-----------------------" + "%n");
        }
        print.close();
    }
}
