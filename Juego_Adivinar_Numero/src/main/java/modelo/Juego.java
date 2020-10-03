package modelo;

import excepciones.JuegoNoIniciadoException;
import excepciones.JuegoTerminadoException;
import excepciones.NumeroIngresadoInvalidoException;

import java.util.Random;

/**
 * Clase representativa del juego, pertenece al modelo de la aplicacion.
 * <p>
 * <p>
 * Invariantes de clase:
 * <p>
 * 1. El estado no puede ser null.
 * 2. Los intentos no pueden ser null.
 * 3. El numero de intentos esta siempre entre 0 (juego iniciado) y 10 (juego finalizado).
 * 4. El numero generado por el juego no puede ser null.
 * 5. El numero generado por el juego debe estar en el intervalo [1, 100].
 */

public class Juego {

    private Integer intentos = 0;
    private String estado = "No iniciado";
    private Integer numeroGenerado = 1;

    /**
     * Método que realiza una inicializacion del juego.
     * PRE: ninguna.
     * POST: se genera un numero con los requerimientos expuestos en el invariante. La cantidad de
     * intentos se setea en 0. El estado del juego pasa a ser "Juego iniciado".
     */
    public void inicializarJuego() {
        verificarInvariantes();
        Random r = new Random();
        numeroGenerado = r.nextInt(100) + 1;
        intentos = 0;
        estado = "Juego iniciado";
        assert intentos == 0 : "No cumple POST.";
        assert (!estado.equals("Juego iniciado")) : "No cumple POST.";
        verificarInvariantes();
    }

    /**
     * Se realiza un intento de la partida.
     * PRE: numero pasado como parametro no es null.
     * POST: se realiza el intento, se incrementa la variable intento en 1 y se actualiza el estado.
     *
     * @param numero que se va a probar.
     * @throws NumeroIngresadoInvalidoException si el numero no esta en el invervalo [1, 100].
     * @throws JuegoTerminadoException          si el juego ya ha terminado (estado != "Juego iniciado").
     */
    public void probar(Integer numero) throws NumeroIngresadoInvalidoException, JuegoTerminadoException {
        verificarInvariantes();
        assert numero != null : "No cumple PRE.";
        if (estado.equals("Perdio") || estado.equals("Acerto") || estado.equals("No iniciado"))
            throw new JuegoTerminadoException("Debe iniciar un nuevo juego");
        if (numero < 1 || numero > 100) {
            throw new NumeroIngresadoInvalidoException("El numero ingresado no esta entre 1 y 100");
        }
        int oldIntentos = intentos;
        intentos++;
        if (numero == numeroGenerado)
            estado = "Acerto";
        else if (intentos == 10)
            estado = "Perdio";
        else if (numero < numeroGenerado)
            estado = "Bajo";
        else
            estado = "Alto";
        assert (estado.equals("Bajo") || estado.equals("Perdio") ||
                estado.equals("Acerto") || estado.equals("Alto")) : "Estado no correspondiente.";
        assert (oldIntentos + 1 == intentos) : "Los intentos no fueron actualizados correctamente.";
        verificarInvariantes();
    }

    /**
     * Devuelve la cantidad de intentos que se han realizado.
     * PRE: ninguna.
     * POST: devuelve los intentos.
     *
     * @return cantidad de intentos realizados.
     * @throws JuegoNoIniciadoException si el juego no ha sido iniciado.
     */
    public Integer traerIntentos() throws JuegoNoIniciadoException {
        if (estado.equals("No iniciado"))
            throw new JuegoNoIniciadoException("El juego no esta iniciado.");
        verificarInvariantes();
        return intentos;
    }

    public String traerEstado() {
        verificarInvariantes();
        return estado;
    }

    /**
     * Método que verifica los invariantes de clase.
     */
    private void verificarInvariantes() {
        assert estado != null : "Estado es null";
        assert intentos != null : "Intentos es null";
        assert (intentos >= 0 && intentos <= 10) : "Numero de intentos invalido";
        assert numeroGenerado != null : "El numero generado es null";
        assert (numeroGenerado > 0 && numeroGenerado <= 100) : "El numero generado no es valido";
    }

}
