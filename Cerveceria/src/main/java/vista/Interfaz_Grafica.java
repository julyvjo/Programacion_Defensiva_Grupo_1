package vista;

import excepciones.NoEnteroException;
import negocio.Negocio;

public class Interfaz_Grafica {
	Negocio negocio = new Negocio();

	private int leerString(String entrada) throws NoEnteroException {
		int salida;
		try {
			salida = Integer.parseInt(entrada);
		} catch (NumberFormatException e) {
			throw new NoEnteroException("No es un numero");
		}
		return salida;

	}

	private void verificarInvariante() {
		assert this.negocio != null : "No existe el negocio";
	}

	public void abrirLocal() {
		try {
			int nroMesas = leerString("10");
		} catch (NoEnteroException e) {
			System.out.println(e.getMessage());
		}
		//this.negocio.abrirLocal(nroMesas);
		verificarInvariante();
	}

	public void ocuparMesa() {

	}

	public void cerrarMesa() {

	}
}
