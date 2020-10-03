package excepciones;

/**
 * Excepcion que es lanzada cuando el nombre de la materia que se ingresa es incorrecto
 */
public class NombreMateriaInvalidoException extends Exception {

    public NombreMateriaInvalidoException(String s) {
        super(s);
    }

}
