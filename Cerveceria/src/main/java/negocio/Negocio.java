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

public class Negocio {
	private BeerHouse bh = new BeerHouse();

	private void verificaInvariante() {
		assert bh != null : "Error de Invariante";
	}

	public void abrirLocal(int cantMesas) throws CantidadNoPositivaMesasException, CantMesasInvalidaException,
			MenuVacioException, YaAbiertoException {
		if (cantMesas >= 1)
			this.bh.abrirLocal(cantMesas);
		else
			throw new CantidadNoPositivaMesasException("Cantidad no positivo de Mesas");
		verificaInvariante();
	}

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
