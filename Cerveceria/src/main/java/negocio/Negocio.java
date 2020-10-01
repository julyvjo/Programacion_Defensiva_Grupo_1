package negocio;

import excepciones.CantMesasInvalidaException;
import excepciones.CantidadNoPositivaMesasException;
import excepciones.LocalNoAbiertoException;
import excepciones.MenuVacioException;
import excepciones.MesaInexistenteException;
import excepciones.MesaNoOcupadaException;
import excepciones.MesaOcupadaException;
import excepciones.NroMesaNoPositivoException;
import excepciones.YaAbiertoException;
import modelo.BeerHouse;
import modelo.Mesa;

/**
 * Clase que representa la capa de Negocio del sistema.
 * 
 * @author Grupo 1
 * 
 */
public class Negocio {
	private BeerHouse bh = new BeerHouse();

	/**
	 * Metodo que verifica el invariante de clase.
	 */
	private void verificaInvariante() {
		assert bh != null : "Error de Invariante";
	}

	/**
	 * Metodo que delega la responsabilidad de abrir el local a la capa de Modelo,
	 * si este falla, delega la excepcion a la clase invocadora del metodo. Ademas,
	 * el metodo verifica que el parametro cantMesas sea siempre positivo, en caso
	 * contrario lanza una excepcion.
	 * 
	 * PRE: Existe la clase BeerHouse <br>
	 * 
	 * POST: Se abre el local.<br>
	 * 
	 * @param cantMesas Entero
	 * @throws CantidadNoPositivaMesasException Si cantMesas <= 0.
	 * @throws CantMesasInvalidaException       Si no hay suficientes mesas en el
	 *                                          local.
	 * @throws MenuVacioException               Si la cantidad de productas == 0.
	 * @throws YaAbiertoException               Si ya esta abierto el local.
	 */
	public void abrirLocal(int cantMesas) throws CantidadNoPositivaMesasException, CantMesasInvalidaException,
			MenuVacioException, YaAbiertoException {
		if (cantMesas >= 1)
			this.bh.abrirLocal(cantMesas);
		else
			throw new CantidadNoPositivaMesasException("Cantidad no positivo de Mesas");
		verificaInvariante();
	}

	/**
	 * Metodo que delega la responsabilidad de ocupar una mesa a la capa de Modelo.
	 * Si esta falla, delega la excepcion recibida a la clase invocadora. Ademas, el
	 * metodo verifica que el parametro nroMesa sea estricamente mayor o igual a 1.
	 * Si es metodo es exitoso retorna la instancia de la mesa ocupada.
	 * 
	 * PRE: Existe la clase BeerHouse. <br>
	 * 
	 * POST: Se ocupa una mesa y se retorna la instancia de la misma.<br>
	 * 
	 * @param nroMesa Entero
	 * @return La instancia mesa ocupada
	 * @throws NroMesaNoPositivoException Si cantMesas <= 0.
	 * @throws MesaInexistenteException   Si no hay suficientes mesas en el local.
	 * @throws MesaOcupadaException       Si la mesa ya estaba ocupada.
	 * @throws LocalNoAbiertoException    Si el local esta cerrado.
	 */
	public Mesa ocuparMesa(int nroMesa)
			throws NroMesaNoPositivoException, MesaInexistenteException, MesaOcupadaException, LocalNoAbiertoException {
		if (nroMesa < 1)
			throw new NroMesaNoPositivoException("Numero no positivo de mesa");
		verificaInvariante();
		return bh.ocuparMesa(nroMesa);
	}

	public float cerrarMesa(int nroMesa) throws NroMesaNoPositivoException, MesaInexistenteException,
			MesaNoOcupadaException, LocalNoAbiertoException {
		if (nroMesa < 1)
			throw new NroMesaNoPositivoException("Numero no positivo de mesa");
		verificaInvariante();
		return bh.cerrarMesa(nroMesa);
	}
}
