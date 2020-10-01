package modelo;

import java.util.ArrayList;

import excepciones.CantMesasInvalidaException;
import excepciones.LocalNoAbiertoException;
import excepciones.MenuVacioException;
import excepciones.MesaInexistenteException;
import excepciones.MesaNoOcupadaException;
import excepciones.MesaOcupadaException;
import excepciones.YaAbiertoException;

/**
 * Clase que representa la cerveria y pertenece al modelo.
 * 
 * @author Grupo 1
 *
 */
public class BeerHouse {
	private Boolean isAbierto = false;
	private int cantMesasMax = 40;
	private ArrayList<Mesa> mesas = new ArrayList<Mesa>();
	private ArrayList<Producto> menu = new ArrayList<Producto>();

	/**
	 * Constructor el cual incializa automaticamente el menú del dia.
	 */
	public BeerHouse() {
		menu.add(new Producto("Pizza"));
		menu.add(new Producto("Milanesa"));
		menu.add(new Producto("Papas Fritas"));
		menu.add(new Producto("Ensalada"));
		menu.add(new Producto("Helado"));
	}

	/**
	 * Metodo que verifica el invariante de clase.
	 */
	private void verificaInvariante() {
		assert menu != null : "No hay menu";
		assert mesas != null : "No hay mesas";
		assert cantMesasMax > 0 : "No hay mesas disponibles";
		assert isAbierto != null : "Feriado";
	}

	/**
	 * Metodo encargado de verificar si el parametro cantMesas es correcto, en caso
	 * de serlo inicializa la cantidad de mesas en el ArrayList y pone en true la
	 * variable isAbierto, de lo contrario lanza una excepcion.
	 * 
	 * PRE: menu != null, mesas!= null <br>
	 * , cantMesasMax > 0 y isAbierto != null<br>
	 * 
	 * POST: El local se abre.
	 * 
	 * @param cantMesas Entero.
	 * @throws CantMesasInvalidaException Si cantMesas > cantMesasMax.
	 * @throws MenuVacioException         Si menu.size() == 0.
	 * @throws YaAbiertoException         So isAbierto == true.
	 */
	public void abrirLocal(int cantMesas) throws CantMesasInvalidaException, MenuVacioException, YaAbiertoException {
		assert cantMesas >= 1 : "Numero de mesas invalido";
		if (isAbierto == true)
			throw new YaAbiertoException("El local no se puede abrir 2 veces");
		if (this.menu.size() == 0)
			throw new MenuVacioException("No hay productos para vender");
		if (cantMesas <= cantMesasMax) {
			for (int i = 0; i < cantMesas; i++) {
				mesas.add(new Mesa());
			}
		} else
			throw new CantMesasInvalidaException("No hay suficientes mesas");
		isAbierto = true;
		verificaInvariante();
	}

	/**
	 * Metodo que ocupa una mesa pasada por parametro y retorna su instancia. El
	 * parametro nroMesa es verificado y en caso de encontrar un error, se lanza la
	 * excepcion correspondiente.
	 * 
	 * PRE: menu != null, mesas!= null <br>
	 * , cantMesasMax > 0 y isAbierto != null<br>
	 * 
	 * POST: Se ocupa una mesa y se retorna su instancia.
	 * 
	 * @param nroMesa Entero
	 * @return La instancia de la mesa ocupada.
	 * @throws MesaInexistenteException Si la mesa no existe.
	 * @throws MesaOcupadaException     Si ya estaba ocupada.
	 * @throws LocalNoAbiertoException  Si el local esta cerrado.
	 */
	public Mesa ocuparMesa(int nroMesa) throws MesaInexistenteException, MesaOcupadaException, LocalNoAbiertoException {
		assert nroMesa >= 1 : "Numero de mesas invalido";
		if (isAbierto == false)
			throw new LocalNoAbiertoException("No esta abierto al publico");
		if (nroMesa > mesas.size())
			throw new MesaInexistenteException("No existe la mesa");
		Mesa mesa = mesas.get(nroMesa);
		if (mesa.getEstado() == 'O')
			throw new MesaOcupadaException("Mesa ya ocupada");
		mesa.setEstado('O');
		verificaInvariante();
		return mesa;
	}

	/**
	 * Metodo que cierra una mesa pasada por parametro y retorna el monto a pagar de
	 * la mesa. El parametro nroMesa es verificado y en caso de error se lanza la
	 * excepcion correspondiente.
	 * 
	 * PRE: menu != null, mesas!= null <br>
	 * , cantMesasMax > 0 y isAbierto != null<br>
	 * 
	 * POST: Se cierra una mesa y se retorna su monto a pagar.
	 * 
	 * @param nroMesa Entero
	 * @return Real con el monto a pagar.
	 * @throws MesaInexistenteException Si no existe la mesa.
	 * @throws MesaNoOcupadaException   Si la mesa solictada no estaba ocupada.
	 * @throws LocalNoAbiertoException  Si el local no esta abierto.
	 */
	public float cerrarMesa(int nroMesa)
			throws MesaInexistenteException, MesaNoOcupadaException, LocalNoAbiertoException {
		assert nroMesa >= 1 : "Numero de mesas invalido";
		if (isAbierto == false)
			throw new LocalNoAbiertoException("No esta abierto al publico");
		if (nroMesa > mesas.size())
			throw new MesaInexistenteException("No existe la mesa");
		Mesa mesa = mesas.get(nroMesa);
		if (mesa.getEstado() == 'L')
			throw new MesaNoOcupadaException("Mesa no ocupada");
		mesa.setEstado('O');
		verificaInvariante();
		return mesa.consumo();
	}

}
