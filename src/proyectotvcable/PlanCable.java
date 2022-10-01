package proyectotvcable;

public class PlanCable extends PlanEmpresa{
    boolean hd;
    int canales;

    public PlanCable(byte id, String nombre, int precio, double valoracion, boolean hd, int canales) {
        super(id, nombre, precio, valoracion);
        this.hd = hd;
        this.canales = canales;
    }

    public void setHd(boolean hd) {
        this.hd = hd;
    }

    public void setCanales(int canales) {
        this.canales = canales;
    }

    public boolean isHd() {
        return hd;
    }

    public int getCanales() {
        return canales;
    }

    public void getPlan(){
        super.getPlan();
        if (isHd()){
            System.out.println("Incluye canales en HD");
        }else{
            System.out.println("No incluye canales en HD");
        }
        System.out.println("Cantidad de Canales: " + getCanales());
    }
}
