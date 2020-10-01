package modelo;

import excepciones.DivisionPorCeroException;
import excepciones.ErrorDeCalculoException;
import excepciones.OperacionInexistenteException;
import excepciones.OperandoNegativoException;

/**
 * Capa de Modelo.<br>
 * 
 * Requisitos:<br>
 * Calculadora para números enteros positivos, cuyos resultados también son
 * enteros positivos (>0).<br>
 * Las operaciones se realizan ingresando dos operandos, la operación y nos debe
 * mostrar el resultado.<br>
 * Se consideran la suma (+), la resta (-), la división (/) y la multiplicación
 * (*).<br>
 * 
 * @author Grupo 1
 *
 */
public class Calculadora {
	private int resultado = -1;

	/**
	 * Metodo que recibe los parametros originales y los verifica, efectua si es
	 * posible la operacion y en caso contrario informa con una excepcion el error
	 * encontrado. <br>
	 * 
	 * PRE: op1 != null; op2 != null; operacion != null. <br>
	 * 
	 * POST: Se guarda en la variable el resultado o se dispara una excepcion.<br>
	 * 
	 * @param op1       Entero
	 * @param op2       Entero
	 * @param operacion String
	 * @throws OperandoNegativoException     Si el operando o el resultado es
	 *                                       negativo.
	 * @throws DivisionPorCeroException      Si se intenta dividir por cero.
	 * @throws OperacionInexistenteException Si la operacion es no valida.
	 */
	public void calcular(int op1, int op2, String operacion)
			throws OperandoNegativoException, DivisionPorCeroException, OperacionInexistenteException {
		assert operacion != null : "Operacion nula";
		if (op1 < 0 || op2 < 0)
			throw new OperandoNegativoException("Operando negativo");
		else if (operacion == "+")
			resultado = op1 + op2;
		else if (operacion == "-") {
			if (op1 < op2)
				throw new OperandoNegativoException("Resultado negativo");
			resultado = op1 - op2;
		} else if (operacion == "*")
			resultado = op1 * op2;
		else if (operacion == "/") {
			if (op2 == 0)
				throw new DivisionPorCeroException("Imposible dividir por cero");
			resultado = op1 / op2;
		} else
			throw new OperacionInexistenteException("No existe la operacion");
	}

	/**
	 * Metodo que retorna el ultimo resultado valido o una excepcion si no se
	 * realizó ninguno.
	 * 
	 * @return El ultimo resultado valido.
	 * @throws ErrorDeCalculoException Si no existe un resultado valido.
	 */
	public int traerResultado() throws ErrorDeCalculoException {
		if (resultado != -1)
			return resultado;
		else
			throw new ErrorDeCalculoException("No se encuentra resultado");
	}
}
