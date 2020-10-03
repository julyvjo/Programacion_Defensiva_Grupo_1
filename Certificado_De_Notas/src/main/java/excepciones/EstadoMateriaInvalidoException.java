package excepciones;

/**
 * Excepcion que es lanzada cuando el estado de una materia dada es incorrecto con respecto a la nota de la misma
 */
public class EstadoMateriaInvalidoException extends Exception {

    public EstadoMateriaInvalidoException(String s) {
        super(s);
    }

}
