package proyectotvcable;

public class IDAlreadyInUseException extends Exception{
    public IDAlreadyInUseException(){
        super("El ID que especifico ya esta en uso.");
    }
}