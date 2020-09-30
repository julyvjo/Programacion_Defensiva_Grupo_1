package vista;

import excepciones.CantidadNoPositivaMesasException;
import excepciones.NoEnteroException;
import excepciones.NroMesaNoPositivoException;
import negocio.Negocio;

/**
 * Clase que simula una interfaz grafica.
 * 
 * @author G1
 */
public class Interfaz_Grafica {
	private Negocio negocio = new Negocio();

	/**
	 * Metodo que transforma un string a integer.
	 * 
	 * @param entrada Un string que debe ser un numero.
	 * @return Integer con el valor del numero.
	 * @throws NoEnteroException Si se ingresa cualquier otro caracter.
	 */
	private int leerString(String entrada) throws NoEnteroException {
		int salida;
		try {
			salida = Integer.parseInt(entrada);
		} catch (NumberFormatException e) {
			throw new NoEnteroException("No es un numero");
		}
		return salida;
	}

	/**
	 * Metodo interno que verifica que siempre se cumpla la condicion invariante.
	 */
	private void verificarInvariante() {
		assert this.negocio != null : "No existe el negocio";
	}

	/**
	 * Metodo que simula la lectura del numero de mesas para abrir el local.
	 */
	public void abrirLocal() {
		int nroMesas = 0;
		try {
			nroMesas = leerString("10");
			this.negocio.abrirLocal(nroMesas);
		} catch (NoEnteroException e) {
			System.out.println(e.getMessage());
		} catch (CantidadNoPositivaMesasException e) {
			System.out.println(e.getMessage());
		}
		verificarInvariante();
	}

	/**
	 * Metodo que simula la lectura de una mesa para abrir.
	 */
	public void ocuparMesa() {
		int nroMesa = 0;
		try {
			nroMesa = leerString("3");
			this.negocio.ocuparMesa(nroMesa);
		} catch (NoEnteroException e) {
			System.out.println(e.getMessage());
		} catch (NroMesaNoPositivoException e) {
			System.out.println(e.getMessage());
		}
		verificarInvariante();
	}

	/**
	 * Metodo que simula la lectura de una mesa para cerrar.
	 */
	public void cerrarMesa() {
		try {
			int nroMesa = leerString("3");
		} catch (NoEnteroException e) {
			System.out.println(e.getMessage());
		}
		// this.negocio.cerrarMesa(nroMesa);
		verificarInvariante();
	}
}
