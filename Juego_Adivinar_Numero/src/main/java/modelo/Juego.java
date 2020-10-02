package modelo;

import excepciones.JuegoTerminadoException;
import excepciones.NumeroIngresadoInvalidoException;

import java.util.Random;

public class Juego {

    private Integer intentos = 0;
    private String estado = "No iniciado";
    private Integer numeroGenerado = 1;

    public void inicializarJuego(){
    	verificarInvariantes();
        Random r = new Random();
        numeroGenerado = r.nextInt(100) + 1;
        intentos = 0;
        estado = "Juego iniciado";
        verificarInvariantes();
    }

    public void probar(Integer numero) throws NumeroIngresadoInvalidoException, JuegoTerminadoException {
        verificarInvariantes();
        if (estado.equals("Perdio") || estado.equals("Acerto") || estado.equals("No iniciado"))
            throw new JuegoTerminadoException("Debe iniciar un nuevo juego");
        if (numero < 1 || numero > 100){
            throw new NumeroIngresadoInvalidoException("El numero ingresado no esta entre 1 y 100");
        }
        intentos++;
        if (numero == numeroGenerado)
            estado = "Acerto";
        else if (intentos == 10)
            estado = "Perdio";
        else if (numero < numeroGenerado)
            estado = "Bajo";
        else
            estado = "Alto";
        verificarInvariantes();
    }

    public Integer traerIntentos(){
        verificarInvariantes();
        return intentos;
    }

    public String traerEstado(){
        verificarInvariantes();
        return estado;
    }

    private void verificarInvariantes(){
        assert estado != null : "Estado es null";
        assert intentos != null : "Intentos es null";
        assert (intentos >= 0 && intentos <= 10) : "Numero de intentos invalido";
        assert numeroGenerado != null : "El numero generado es null";
        assert (numeroGenerado > 0 && numeroGenerado <= 100) : "El numero generado no es valido";
    }

}
