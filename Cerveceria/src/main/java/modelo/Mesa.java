package modelo;

/**
 * Clase que representa las mesas del local.
 * 
 * @author Grupo 1
 *
 */
public class Mesa {
	private char estado = 'L';

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public float consumo() {
		return 10;
	}
}
