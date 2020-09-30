package negocio;

import excepciones.CantidadNoPositivaMesasException;
import excepciones.NroMesaNoPositivoException;
import modelo.BeerHouse;
import modelo.Mesa;

public class Negocio {
	private BeerHouse bh = new BeerHouse();

	
	public void abrirLocal(int cantMesas) throws CantidadNoPositivaMesasException {
		if (cantMesas >= 1)
			this.bh.abrirLocal(cantMesas);
		else
			throw new CantidadNoPositivaMesasException("Cantidad no positivo de Mesas");
	}
	
	public Mesa ocuparMesa(int nroMesa) throws NroMesaNoPositivoException {
		if (nroMesa < 1)
			throw new NroMesaNoPositivoException("Numero no positivo de mesa");
		return bh.ocuparMesa(nroMesa);
	}
	
	public void cerrarMesa() {
	
	}
}
