package modelo;

import excepciones.fracasoException;

public class Surtidor {

    final private double capacidad_maxima_deposito = 2000;
    private double cantidad_Combustible = 0;
    private double acumuladoManguera1;
    private double acumuladoManguera2;
    private double ultimaventaManguera1;
    private double ultimaventaManguera2;

	/*
	 * 	Requerimientos aplicables:
	 *
		1. El surtidor está conectado a un deposito con capacidad máxima de 2000 litros, todo intento
		de cargar más de eso se aborta, no se realiza la carga.
		2. El surtidor se inicia con una cantidad inicial de combustible>=1 y el resto de las variables
		(acumulado de ventas y última venta de cada mangueras) en cero.
		3. El surtidor para estar en funcionamiento debe tener combustible
		(cantidad_Combustible>=1).
		4. Cuando el surtidor se queda vacío, la única operación posible es la recarga de combustible.
		5. El surtidor cuenta con dos mangueras que entregan combustible cuando el aperador acciona
		el gatillo de la boquilla, esta acción transcurre mientras hay combustible en el surtidorhasta
		que el operador libera el gatillo.
		6. Las mangueras entregan combustible a razón de un litro por segundo, reduciendo el stock
		del surtidor y mostrando en la pantalla del surtidor el total de combustible restante en el
		surtidor y el entregado por cada manguera (acumulado) y en la última compra.
	 */




    /*
     * carga es la cantidad de combustible inicial que se incorpora en cantidad_Combustible.
     * Inicializa acumuladoManguera1, acumuladoManguera2, ultimaventaManguera1 y ultima venta Manguera2 en cero.
     *
     * pre:
     * post: inicializa los atributos de la clase o de no ser posible lanza una excepcion de fracaso
     */
    public void InicializarSurtidor(double carga) throws fracasoException {

        if( 1 <= carga && (carga + this.cantidad_Combustible <= capacidad_maxima_deposito) ) { //podria querer inicializarse el surtidor teniendo combistible de antes
            this.cantidad_Combustible = carga;
            this.acumuladoManguera1 = 0;
            this.acumuladoManguera2 = 0;
            this.ultimaventaManguera1 = 0;
            this.ultimaventaManguera2 = 0;
        }else
            throw new fracasoException("carga inválida para inicializar surtidor");
    }




    /*
     * incorpora la cantidad que indica carga en el surtidor incrementando la variable cantidad_Combustible.
     *
     * pre:
     * post: carga el deposito de combustible o lanza una excepcion de fracaso
     */
    public void cargarSurtidor(double carga) throws fracasoException {

        if( 0 <= carga && (carga + this.cantidad_Combustible <= capacidad_maxima_deposito) )
            this.cantidad_Combustible += carga;
        else
            throw new fracasoException("carga inválida");
    }



    /*
     * Recibe de la capa de negocio el pedido para que la Manguera1 comience a descargar, verifica si es posible, en ese caso comienza la descarga.
     * Sigue descargando a razón de un litro por segundo hasta que se reciba la señal de desactivar la manquera o bien el deposito se vacíe.
     * En ambos casos actualiza los acumulados de la manguera 1 y la existencia, e informa a la capa de negocio lo que acontece.
     * Si la acción es imposible informa a la capa de negocio.
     *
     * pre:
     * post: se activa la manguera o se lanza una excepción
     */
    public void descargaManguera1() throws fracasoException {

        if( 0 < this.cantidad_Combustible ) {
            //Simula cargar combustible a razon de 1L por segundo y actualiza valores para manguera 1
        }else {
            throw new fracasoException("la manguera 1 no puede cargar combustible porque el deposito esta vacio");
        }

    }



    /*
     * Recibe de la capa de negocio el pedido para que la Manguera2 comience a descargar, verifica si es posible, en ese caso comienza la descarga.
     * Sigue descargando a razón de un litro por segundo hasta que se reciba la señal de desactivar la manquera o bien el deposito se vacíe.
     * En ambos casos actualiza los acumulados de manguera 1 y la existencia, e informa a la capa de negocio lo que acontece.
     * Si la acción es imposible informa a la capa de negocio.
     *
     * pre:
     * post:
     */
    public void activaManguera2() throws fracasoException{

        if( 0 < this.cantidad_Combustible ) {
            //Simula cargar combustible a razon de 1L por segundo y actualiza valores para manguera 2
        }else {
            throw new fracasoException("la manguera 1 no puede cargar combustible porque el deposito esta vacio");
        }
    }



    /*
     * Devuelve la existencia del deposito desde la capa de modelo
     *
     * pre:
     * post:
     */
    public double getExistenciaDeposito() {
        return this.cantidad_Combustible;

    }




    /*
     * Devuelve el acumulado de la manguera 1, desde la capa del modelo
     *
     * pre:
     * post:
     */
    public double getAcumuladoManguera1() {
        return this.acumuladoManguera1;

    }




    /*
     * Devuelve el acumulado de la manguera 2, desde la capa del modelo
     *
     * pre:
     * post:
     */
    public double getAcumuladoManguera2() {
        return this.acumuladoManguera2;

    }




    /*
     * Devuelve la última venta de la manguera 1
     *
     * pre:
     * post:
     */
    public double getUltimaVentaMG1() {
        return this.ultimaventaManguera1;

    }




    /*
     * Devuelve la última venta de la manguera 2
     *
     * pre:
     * post:
     */
    public double getUltimaVentaMG2() {
        return this.ultimaventaManguera2;

    }









}
