package modelo;

import java.util.ArrayList;

import excepciones.CantMesasInvalidaException;
import excepciones.LocalNoAbiertoException;
import excepciones.MenuVacioException;
import excepciones.MesaInexistenteException;
import excepciones.MesaNoOcupadaException;
import excepciones.MesaOcupadaException;
import excepciones.YaAbiertoException;

public class BeerHouse {
	private Boolean isAbierto = false;
	private int cantMesasMax = 40;
	private ArrayList<Mesa> mesas = new ArrayList<Mesa>();
	private ArrayList<Producto> menu = new ArrayList<Producto>();
	
	public BeerHouse() {
		menu.add(new Producto("Pizza"));
		menu.add(new Producto("Milanesa"));
		menu.add(new Producto("Papas Fritas"));
		menu.add(new Producto("Ensalada"));
		menu.add(new Producto("Helado"));
	}
	
	private void verificaInvariante() {
		assert menu != null: "No hay menu";
		assert mesas != null: "No hay mesas";
		assert cantMesasMax > 0: "No hay mesas disponibles";
		assert isAbierto != null: "Feriado";
	}
	
	public void abrirLocal(int cantMesas) throws CantMesasInvalidaException, MenuVacioException, YaAbiertoException {
		assert cantMesas >= 1 : "Numero de mesas invalido";
		if(isAbierto == true)
			throw new YaAbiertoException("El local no se puede abrir 2 veces");
		if(this.menu.size() == 0) 
			throw new  MenuVacioException("No hay productos para vender");
		if (cantMesas <= cantMesasMax) {
			for (int i = 0; i < cantMesas; i++) {
				mesas.add(new Mesa());
			}
		}
		else
			throw new CantMesasInvalidaException("No hay suficientes mesas");
		isAbierto = true;
		verificaInvariante();
	}

	public Mesa ocuparMesa(int nroMesa) throws MesaInexistenteException, MesaOcupadaException, LocalNoAbiertoException {
		assert nroMesa >= 1 : "Numero de mesas invalido";
		if(isAbierto==false)
			throw new LocalNoAbiertoException("No esta abierto al publico");
		if(nroMesa > mesas.size())
			throw new MesaInexistenteException("No existe la mesa");
		Mesa mesa = mesas.get(nroMesa);
		if(mesa.getEstado() == 'O')
			throw new MesaOcupadaException("Mesa ya ocupada");
		mesa.setEstado('O');
		verificaInvariante();
		return mesa;
	}

	public float cerrarMesa(int nroMesa) throws MesaInexistenteException, MesaNoOcupadaException, LocalNoAbiertoException {
		assert nroMesa >= 1 : "Numero de mesas invalido";
		if(isAbierto==false)
			throw new LocalNoAbiertoException("No esta abierto al publico");
		if(nroMesa > mesas.size())
			throw new MesaInexistenteException("No existe la mesa");
		Mesa mesa = mesas.get(nroMesa);
		if(mesa.getEstado() == 'L')
			throw new MesaNoOcupadaException("Mesa no ocupada");
		mesa.setEstado('O');
		verificaInvariante();
		return mesa.consumo();
	}

}
