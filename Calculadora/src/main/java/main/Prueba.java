package main;

import negocio.Monitor;

public class Prueba {

	public static void main(String[] args) {
		Monitor m = new Monitor();
		m.calcular(m.getUI().leerOp1(), m.getUI().leerOp2(), m.getUI().leerOperando());
		m.traerResultado();
	}

}
