package main;

import vista.UI;

public class Prueba {

	public static void main(String[] args) {
		UI calc = new UI();
		calc.calcular("10", "10", "+");
		calc.calcular("10", "-10", "+");
		calc.calcular("a", "10", "+");
		calc.calcular("10", "10", "a");
		calc.calcular("10", "0", "/");
		calc.calcular("10", "40", "-");
		calc.mostrarResultado();
	}

}
