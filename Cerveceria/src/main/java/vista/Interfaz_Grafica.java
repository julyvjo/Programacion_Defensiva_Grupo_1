package vista;

import excepciones.CantMesasInvalidaException;
import excepciones.CantidadNoPositivaMesasException;
import excepciones.LocalNoAbiertoException;
import excepciones.MenuVacioException;
import excepciones.MesaInexistenteException;
import excepciones.MesaNoOcupadaException;
import excepciones.MesaOcupadaException;
import excepciones.NoEnteroException;
import excepciones.NroMesaNoPositivoException;
import excepciones.YaAbiertoException;
import negocio.Negocio;

/**
 * Clase que simula una interfaz grafica.
 * 
 * @author Grupo 1
 */
public class Interfaz_Grafica {
	private Negocio negocio = new Negocio();

	/**
	 * Metodo que transforma un string a integer.<br>
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
	 * Metodo que simula la lectura del numero de mesas para abrir el local, si se
	 * produce algun error trata las excepciones por medio de un mensaje por
	 * pantalla.
	 * 
	 * PRE: Existe el negocio.<br>
	 * 
	 * POST: Se abre el local.<br>
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
		} catch (CantMesasInvalidaException e) {
			System.out.println(e.getMessage());
		} catch (MenuVacioException e) {
			System.out.println(e.getMessage());
		} catch (YaAbiertoException e) {
			System.out.println(e.getMessage());
		}
		verificarInvariante();
	}

	/**
	 * Metodo que simula la lectura de una mesa para abrir, si la mesa no existe o
	 * es un valor invalido trata la excepcion por medio de un mensaje por
	 * pantalla.<br>
	 * 
	 * PRE: Existe el negocio.
	 * 
	 * POST: Se ocupa una mesa.<br>
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
		} catch (MesaInexistenteException e) {
			System.out.println(e.getMessage());
		} catch (MesaOcupadaException e) {
			System.out.println(e.getMessage());
		} catch (LocalNoAbiertoException e) {
			System.out.println(e.getMessage());
		}
		verificarInvariante();
	}

	/**
	 * Metodo que simula la lectura de una mesa para cerrar, si la mesa no existe o
	 * no estaba ocupada trata la excepcion por medio de un mensaje por
	 * pantalla.<br>
	 * 
	 * PRE: Existe el negocio.<br>
	 * 
	 * POST: Se cierra una mesa.<br>
	 */
	public void cerrarMesa() {
		int nroMesa = 0;
		try {
			nroMesa = leerString("3");
			this.negocio.cerrarMesa(nroMesa);
		} catch (NoEnteroException e) {
			System.out.println(e.getMessage());
		} catch (NroMesaNoPositivoException e) {
			System.out.println(e.getMessage());
		} catch (MesaInexistenteException e) {
			System.out.println(e.getMessage());
		} catch (MesaNoOcupadaException e) {
			System.out.println(e.getMessage());
		} catch (LocalNoAbiertoException e) {
			System.out.println(e.getMessage());
		}
		verificarInvariante();
	}
}
