package negocio;

import modelo.Calculadora;
import vista.UI;

public class Monitor {
	Calculadora calc = new Calculadora();
	UI ui = new UI();

	public UI getUI() {
		return ui;
	}

	/**
	 * Metodo que delega la responsabilidad de calculo a la clase Monitor.
	 * 
	 * @param op1      Entero positivo.
	 * 
	 * @param op2      Entero positivo.
	 * 
	 * @param operando Char (+, -, * o /).
	 */
	public void calcular(int op1, int op2, char operando) {
		try {
			calc.calcular(op1, op2, operando);
		} catch (Exception e) {
			this.ui.mostrarEstado(e.getMessage());
		}
	}

	/**
	 * Metodo que delega la responsabilidad de mostrar por pantalla el resultado a
	 * la clase UI.
	 * 
	 * Si no es posible trata la excepcion mostrando por medio de la UI el msj.
	 */
	public void traerResultado() {
		try {
			int res = calc.traerResultado();
			ui.mostrarResultado(res);
		} catch (Exception e) {
			ui.mostrarEstado(e.getMessage());
		}
	}
}
