package negocio;

import excepciones.DivisionPorCeroException;
import excepciones.ErrorDeCalculoException;
import excepciones.OperacionInexistenteException;
import excepciones.OperandoNegativoException;
import modelo.Calculadora;

/**
 * Capa de Negocio.
 * 
 * @author Grupo 1
 *
 */
public class Monitor {
	Calculadora calc = new Calculadora();

	/**
	 * Metodo que delega la responsabilidad del calculo a la clase Calculadora, si
	 * este mismo falla, delega el manejo de la excepcion a la clase invocadora.
	 * 
	 * PRE: Existe la calculadora.<br>
	 * 
	 * POST: Se ejecuta el metodo calcular() de la clase Calculadora.<br>
	 * 
	 * @param op1       Integer
	 * @param op2       Integer
	 * @param operacion String
	 * @throws OperandoNegativoException     Si el operando ingresado es negativo o
	 *                                       si el resultado es negativo
	 * @throws DivisionPorCeroException      Si se intenta dividir por cero.
	 * @throws OperacionInexistenteException Si el caracter de operacion no es
	 *                                       reconocible
	 */
	public void calcular(int op1, int op2, String operacion)
			throws OperandoNegativoException, DivisionPorCeroException, OperacionInexistenteException {
		invariante();
		calc.calcular(op1, op2, operacion);
	}

	/**
	 * Metodo que obtiene el resultado de la ultima operacion exitosa y lo
	 * retorna.<br>
	 * 
	 * PRE: Existe la calculadora.<br>
	 * 
	 * POST: Devuelve un entero o lanza excepcion.<br>
	 * 
	 * @return Entero que representa el resultado de la ultima operacion exitosa.
	 * @throws ErrorDeCalculoException Si no se encuentra ningun resultado.
	 */
	public int traerResultado() throws ErrorDeCalculoException {
		invariante();
		return calc.traerResultado();
	}
	
	private void invariante() {
		assert calc != null: "Calculadora no existente";
	}
}
