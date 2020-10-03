package excepciones;

/**
 * Excepcion que es lanzada cuando el certificado pedido no existe o es null
 */
public class CertificadoInexistenteException extends Exception {

    public CertificadoInexistenteException(String s) {
        super(s);
    }

}
