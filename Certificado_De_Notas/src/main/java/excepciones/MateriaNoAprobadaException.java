package excepciones;

/**
 * Excepcion que es lanzada cuando la materia no está aprobada
 */
public class MateriaNoAprobadaException extends Exception {

    public MateriaNoAprobadaException(String s) {
        super(s);
    }

}
