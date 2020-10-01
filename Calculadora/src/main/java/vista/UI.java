package vista;

import excepciones.DivisionPorCeroException;
import excepciones.ErrorDeCalculoException;
import excepciones.NoEnteroException;
import excepciones.OperacionInexistenteException;
import excepciones.OperandoNegativoException;
import negocio.Monitor;

/**
 * Capa de Interfaz de Usuario.
 * 
 * @author Grupo 1
 *
 */
public class UI {
	Monitor monitor = new Monitor();

	/**
	 * Metodo que transforma un string a integer.
	 * 
	 * @param entrada Un string que debe ser un numero.
	 * @return Integer con el valor del numero.
	 * @throws NoEnteroException Si se ingresa cualquier otro caracter.
	 */
	private int leerEntero(String entrada) throws NoEnteroException {
		int salida;
		try {
			salida = Integer.parseInt(entrada);
		} catch (NumberFormatException e) {
			throw new NoEnteroException("No es un numero");
		}
		return salida;
	}

	/**
	 * Metodo que delega la responsabilidad del calculo a la clase Monitor.<br>
	 * 
	 * PRE: Existe el monitor.<br>
	 * POST: Se efectua el calculo esperade. En caso de fallo, se trata la excepcion
	 * correspondiente mostrando su estado por pantalla.<br>
	 * 
	 * @param op1       String
	 * @param op2       String
	 * @param operacion String
	 */
	public void calcular(String op1, String op2, String operacion) {
		try {
			int intOp1 = leerEntero(op1);
			int intOp2 = leerEntero(op2);
			invariante();
			this.monitor.calcular(intOp1, intOp2, operacion);
			mostrarEstado("Operacion exitosa");
		} catch (NoEnteroException e) {
			mostrarEstado(e.getMessage());
		} catch (OperandoNegativoException e) {
			mostrarEstado(e.getMessage());
		} catch (DivisionPorCeroException e) {
			mostrarEstado(e.getMessage());
		} catch (OperacionInexistenteException e) {
			mostrarEstado(e.getMessage());
		}
		invariante();
	}

	/**
	 * Metodo que muestra el estado actual de la calculadora.
	 * 
	 * @param msg String que describe el estado.
	 */
	private void mostrarEstado(String msg) {
		System.out.println("El Estado actual es: " + msg);
	}

	/**
	 * Metodo que muestra el ultimo resultado exitoso de la calculadora, en caso de
	 * no existir, lo informa por medio del metodo mostrarEstado().<br>
	 * 
	 * PRE: Existe el monitor.<br>
	 * 
	 * POST: Se muestra el resultado o el estado correspondiente.<br>
	 */
	public void mostrarResultado() {
		try {
			invariante();
			System.out.println("Ultimo resultado valido: " + monitor.traerResultado());
		} catch (ErrorDeCalculoException e) {
			mostrarEstado(e.getMessage());
		}
	}
	
	private void invariante() {
		assert monitor != null: "Monitor no existente";
	}
}
