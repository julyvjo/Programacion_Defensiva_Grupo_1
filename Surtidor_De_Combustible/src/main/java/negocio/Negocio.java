package negocio;

import excepciones.DepositoVacioException;
import excepciones.fracasoException;
import modelo.Surtidor;

public class Negocio {

    private Surtidor surtidor = new Surtidor();


    /*
     * Recibe de la interfaz de usuario la cantidad de litros de combustible a cargar en el depósito del surtidor sin ningún tipo de validación.
     * Envía la orden a la capa del modelo e informa a la interfaz el éxito o fracaso de la operación.
     *
     * pre:
     * post: se inicializa el surtidor, o se propaga una excepcion
     */
    public void Inicializa_Surtidor (double carga) throws fracasoException{
        surtidor.InicializarSurtidor(carga);
    }


    /*
     * Recibe de la interfaz de usuario la cantidad de litros de combustible a cargar en el depósito del surtidor sin ningún tipo de validación.
     * Envía la orden a la capa del modelo e informa a la interfaz el éxito o fracaso de la operación.
     *
     * pre:
     * post: se carga el surtidor o se propaga una excepcion
     */
    public void cargaSurtidor(double carga) throws fracasoException {
        surtidor.cargarSurtidor(carga);
    }



    /*
     * Recibe de la interfaz de usuario el pedido para que la Manguera1 comience a descargar, la capa de negocio transfiere a la capa de modelo.
     * Informa si la acción es posible o no (según informa la capa de modelo).
     *
     * pre:
     * post: se activa la manguera 1 o se propagauna excepcion
     */
    public void activaManguera1() throws fracasoException {
        surtidor.descargaManguera1();
    }




    /*
     * Recibe de la interfaz de usuario el pedido para que la Manguera2 comience a descargar, la capa de negocio transfiere a la capa de modelo.
     * Informa si la acción es posible o no (según informa la capa de modelo).
     *
     * pre:
     * post: se activa la manguera 2 o se propaga una excepción
     */
    public void activaManguera2() throws fracasoException {
        surtidor.activaManguera2();
    }



    /*
     * Recibe de la interfaz de usuario que se para la descarga de combustible.
     * Informa a la interfaz que la operación se detiene porque no hay más combustible cuando le informa la capa de modelo y detiene la descarga automáticamente.
     *
     * pre:
     * post: detiene la manguera 1 e informa a interfaz
     */
    public String DesactivaManguera1() throws DepositoVacioException {

        String informe = null;

        //simula detener la manguera
        informe = "Acumulado Manguera 1 = " + surtidor.getAcumuladoManguera1() + "\n";
        informe += "Ultima venta Manguera 1 = " + surtidor.getUltimaVentaMG1();

        if(surtidor.getExistenciaDeposito() == 0) {
            throw new DepositoVacioException("Se detuvo la manguera 1 por falta de combustible" + "\n" + informe);
        }

        return informe;
    }



    /*
     * Recibe de la interfaz de usuario que se para la descarga de combustible.
     * Informa a la interfaz que la operación se detiene porque no hay más combustible cuando le informa la capa de modelo y detiene la descarga automáticamente.
     *
     * pre:
     * post: detiene la manguera 2 e informa a la interfaz
     */
    public String DesactivaManguera2() throws DepositoVacioException {
        String informe = null;

        //simula detener la manguera
        informe = "Acumulado Manguera 2 = " + surtidor.getAcumuladoManguera2() + "\n";
        informe += "Ultima venta Manguera 2 = " + surtidor.getUltimaVentaMG2();

        if(surtidor.getExistenciaDeposito() == 0) {
            throw new DepositoVacioException("Se detuvo la manguera 2 por falta de combustible" + "\n" + informe);
        }

        return informe;
    }



    /*
     * Devuelve la existencia del deposito desde la capa de modelo
     *
     * pre: el valor esta inicializado
     * post: devuelve el valor pedido
     */
    public double getExistenciaDeposito() {
        return surtidor.getExistenciaDeposito();

    }



    /*
     * Devuelve el acumulado de la manguera 1, desde la capa del modelo
     *
     * pre: el valor esta inicializado
     * post: devuelve el valor pedido
     */
    public double getAcumuladoManguera1() {
        return surtidor.getAcumuladoManguera1();

    }



    /*
     * Devuelve el acumulado de la manguera 2, desde la capa del modelo
     *
     * pre: el valor esta inicializado
     * post: devuelve el valor pedido
     */
    public double getAcumuladoManguera2() {
        return surtidor.getAcumuladoManguera2();

    }




    /*
     * Devuelve la última venta de la manguera 1
     *
     * pre: el valor esta inicializado
     * post: devuelve el valor pedido
     */
    public double getUltimaVentaMG1() {
        return surtidor.getUltimaVentaMG1();

    }




    /*
     * Devuelve la última venta de la manguera 2
     *
     * pre: el valor esta inicializado
     * post: devuelve el valor pedido
     */
    public double getUltimaVentaMG2() {
        return surtidor.getUltimaVentaMG2();

    }











}