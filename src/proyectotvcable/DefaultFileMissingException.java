package proyectotvcable;

import java.io.FileNotFoundException;

public class DefaultFileMissingException extends FileNotFoundException {
	public DefaultFileMissingException(){
        super("Archivo predeterminado no fue encontrado");
    }
}
