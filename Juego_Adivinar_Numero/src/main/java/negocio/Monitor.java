package negocio;

import excepciones.JuegoTerminadoException;
import excepciones.NumeroIngresadoInvalidoException;
import modelo.Juego;

public class Monitor {

    private Juego juego = new Juego();

    public void inicializarJuego(){
        verificarInvariantes();
        juego.inicializarJuego();
        verificarInvariantes();
    }

    public void probarNumero(Integer numero) throws NumeroIngresadoInvalidoException, JuegoTerminadoException {
        verificarInvariantes();
        juego.probar(numero);
        verificarInvariantes();
    }

    public Integer traerIntentos(){
        verificarInvariantes();
        return juego.traerIntentos();
    }

    public String traerEstado(){
        verificarInvariantes();
        return juego.traerEstado();
    }

    private void verificarInvariantes(){
        assert juego != null : "No existe el juego";
    }

}
