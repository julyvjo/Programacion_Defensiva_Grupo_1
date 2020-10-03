package excepciones;

/**
 * Excepcion que es lanzada cuando una o más materias de un alumno son null o distintas a las predefinidas
 */
public class MateriasInvalidasException extends Exception {

    public MateriasInvalidasException(String s) {
        super(s);
    }

}
