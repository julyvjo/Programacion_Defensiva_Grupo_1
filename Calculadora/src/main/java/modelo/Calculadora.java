package modelo;

public class Calculadora {
	private int resultado = -1;

	/**
	 * Metodo que calcula el resultado de una operacion pasada por parametro.
	 * 
	 * @param op1      Entero positivo.
	 * 
	 * @param op2      Entero positivo.
	 * 
	 * @param operando Char (+, -, * o /).
	 * 
	 * @throws Exception Si se intenta dividir por 0.
	 */
	public void calcular(int op1, int op2, char operando) throws Exception {
		assert op1 >= 0 : "Operando 1 negativo";
		assert op2 >= 0 : "Operando 2 negativo";
		if (operando == '/' && op2 == 0)
			throw new Exception("Operacion Invalida");
		else if (operando == '+')
			resultado = op1 + op2;
		else if (operando == '-')
			resultado = op1 - op2;
		else if (operando == '*')
			resultado = op1 * op2;
		else
			resultado = op1 / op2;
		assert invariante() : "Invariante";
	}

	/**
	 * Metodo que retorna el resultado de la ultima operacion.
	 * 
	 * @return Entero positivo.
	 * 
	 * @throws Exception si la ultima operacion no pudo efectuarse.
	 */
	public int traerResultado() throws Exception {
		if (resultado != -1)
			return resultado;
		else
			throw new Exception("Resultado Inexistente");
	}

	/**
	 * Metodo interno de control de invariante.
	 * 
	 * @return V o F si se cumple la condicion.
	 */
	private boolean invariante() {
		return resultado >= 0;
	}
}
