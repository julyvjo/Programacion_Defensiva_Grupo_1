package excepciones;

/**
 * Excepcion que es lanzada cuando el legajo ingresado no existe
 */
public class LegajoInvalidoException extends Exception {

    public LegajoInvalidoException(String s) {
        super(s);
    }

}
