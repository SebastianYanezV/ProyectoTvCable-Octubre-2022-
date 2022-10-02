package proyectotvcable;

public class PlanTelefonia extends PlanEmpresa{
    private boolean roaming;
    private int minutos;

    public PlanTelefonia(byte id, String nombre, int precio, double valoracion, boolean roaming, int minutos) {
        super(id, nombre, precio, valoracion);
        this.roaming = roaming;
        this.minutos = minutos;
    }

    public void setRoaming(boolean roaming) {
        this.roaming = roaming;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public boolean isRoaming() {
        return roaming;
    }

    public int getMinutos() {
        return minutos;
    }

    //Funcion para mostrar los datos del plan, muestra sus datos generales (tipo PlanEmpresa) y particulares
    public void getPlan(){
        super.getPlan();
        if (isRoaming()){
            System.out.println("Incluye Roaming Ilimitado");
        }else{
            System.out.println("No incluye Roaming Ilimitado");
        }
        System.out.println("Minutos: " + getMinutos());
    }
}