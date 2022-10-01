package proyectotvcable;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class mapaEmpresas {
    private HashMap<String, Empresa> mapaEmpresas;

    public mapaEmpresas(){
        this.mapaEmpresas = new HashMap<>();
    }

    public HashMap<String, Empresa> getMapa(){
        HashMap<String, Empresa> m = mapaEmpresas;
        return m;
    }

    public void lecturaArchivo() throws IOException {
        String localDir = System.getProperty("user.dir");
        File file = new File(localDir + "\\Planes.csv");
        BufferedReader lector = new BufferedReader((new FileReader(file)));
        String linea;
        while ((linea = lector.readLine()) != null) {
            String[] datos = linea.split(",");
            Empresa busqueda = this.mapaEmpresas.get(datos[0]);
            if (busqueda == null){
                Empresa emp = new Empresa(datos[0]);
                PlanEmpresa plan = new PlanEmpresa(Byte.parseByte(datos[1]), datos[2], Integer.parseInt(datos[3]), Double.parseDouble(datos[4]));
                emp.getPlanes().addPlan(plan);
                this.mapaEmpresas.put(datos[0], emp);
            }
            else{
                PlanEmpresa plan = new PlanEmpresa(Byte.parseByte(datos[1]), datos[2], Integer.parseInt(datos[3]), Double.parseDouble(datos[4]));
                busqueda.getPlanes().addPlan(plan);
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

    public void exportarArchivo() throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese nombre del archivo al cual exportar: ");
        String nombreArchivo = lector.readLine() + ".csv";
        ArrayList<String[]> lineas = new ArrayList<>();
        ArrayList<Empresa> empresas = new ArrayList<>(this.mapaEmpresas.values());
        for (int i = 0; i < empresas.size(); i++){
            for (int j = 0; j < empresas.get(i).getPlanes().getListaPlanes().size(); j++){
                lineas.add(new String[]{ empresas.get(i).getNombre(),
                        String.valueOf(empresas.get(i).getPlanes().getListaPlanes().get(j).getId()),
                        empresas.get(i).getPlanes().getListaPlanes().get(j).getNombre(),
                        String.valueOf(empresas.get(i).getPlanes().getListaPlanes().get(j).getPrecio()),
                        String.valueOf(empresas.get(i).getPlanes().getListaPlanes().get(j).getValoracion())
                });
            }
        }
        File csv = new File(nombreArchivo);
        try(PrintWriter pw = new PrintWriter(csv)){
            lineas.stream().map(this::convertToCSV).forEach(pw::println);
        }
        assert(csv.exists());
    }

    public void listarEmpresas(){
        int j = 1;
        for (String i : this.mapaEmpresas.keySet())
        {
            System.out.println("Empresa "+ j++ + ": " + i);
        }
    }
}
