package vista;

public class UI {

	/**
	 * Metodo que simula la lectura de un nro por una interfaz
	 * 
	 * Pre: El nro debe ser entero positivo
	 * 
	 * Post: Devuelve un nro entero
	 * 
	 * @return Entero leido por pantalla
	 */
	public int leerOp1() {
		return 10;
	}

	/**
	 * Metodo que simula la lectura de un nro por una interfaz
	 * 
	 * Pre: El nro debe ser entero positivo
	 * 
	 * Post: Devuelve un nro entero
	 * 
	 * @return Entero leido por pantalla
	 */
	public int leerOp2() {
		return 2;
	}

	/**
	 * Metodo que simula la lectura de una operacion por una interfaz
	 * 
	 * Pre: El caract debe ser un +, -, * o /
	 * 
	 * Post: Devuelve un caracter
	 * 
	 * @return Char de operacion
	 */
	public char leerOperando() {
		return '+';
	}

	/**
	 * Metodo que muestra el estado por pantalla
	 * 
	 * @param msg Estado a mostrar
	 */
	public void mostrarEstado(String msg) {
		System.out.println("El Estado es: " + msg);
	}

	/**
	 * Metodo que muestra el resultado por pantalla
	 * 
	 * @param resultado Entero a mostrar
	 */
	public void mostrarResultado(int resultado) {
		System.out.println("El resultado es: " + resultado);
	}
}
