package excepciones;

/**
 * Excepcion que se lanza cuando la nota de una materia es incorrecta
 */
public class NotaInvalidaException extends Exception {

    public NotaInvalidaException(String s) {
        super(s);
    }

}
