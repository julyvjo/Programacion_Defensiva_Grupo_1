package excepciones;

public class DepositoVacioException extends Exception{

    public DepositoVacioException(String mensaje) {
        super(mensaje);
    }
}
