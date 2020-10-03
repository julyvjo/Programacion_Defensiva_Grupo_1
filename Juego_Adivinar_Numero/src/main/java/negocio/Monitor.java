package negocio;

import excepciones.JuegoNoIniciadoException;
import excepciones.JuegoTerminadoException;
import excepciones.NumeroIngresadoInvalidoException;
import modelo.Juego;

/**
 * Clase que actua como el negocio de la aplicacion.
 * <p>
 * Invariante de clase: el juego no es null.
 */

public class Monitor {

    private Juego juego = new Juego();

    /**
     * Pide al juego que se haga una inicializacion.
     * PRE: ninguna.
     * POST: el juego fue inicializado.
     */
    public void inicializarJuego() {
        verificarInvariantes();
        juego.inicializarJuego();
        verificarInvariantes();
    }

    /**
     * Se realiza un pedido al modelo para que se haga un intento.
     * PRE: numero != null.
     * POST: se completa el pedido.
     *
     * @param numero: numero que se probara en el juego.
     * @throws NumeroIngresadoInvalidoException si el numero pasado como parametro no esta en el intervalo
     *                                          que determina el juego.
     * @throws JuegoTerminadoException          si el juego ya ha terminado y no es posible realizar nuevos intentos.
     */
    public void probarNumero(Integer numero) throws NumeroIngresadoInvalidoException, JuegoTerminadoException {
        verificarInvariantes();
        assert numero != null: "No cumple PRE.";
        juego.probar(numero);
        verificarInvariantes();
    }

    /**
     * Pide al modelo la cantidad de intentos realizados.
     * PRE: ninguna.
     * POST: retorna el valor solicidato.
     *
     * @return cantidad de intentos realizados
     * @throws JuegoNoIniciadoException si el juego no ha sido iniciado antes.
     */
    public Integer traerIntentos() throws JuegoNoIniciadoException {
        verificarInvariantes();
        return juego.traerIntentos();
    }

    /**
     * Realiza el pedido al modelo para obtener el estado.
     * PRE: ninguna.
     * POST: retorna el estado.
     *
     * @return: estado del juego.
     */
    public String traerEstado() {
        verificarInvariantes();
        return juego.traerEstado();
    }

    /**
     * Verifica los inveriantes de la clase.
     */
    private void verificarInvariantes() {
        assert juego != null : "No existe el juego";
    }

}
