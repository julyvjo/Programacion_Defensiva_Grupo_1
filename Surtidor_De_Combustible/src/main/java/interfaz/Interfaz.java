package interfaz;

import excepciones.DepositoVacioException;
import excepciones.fracasoException;
import negocio.Negocio;

public class Interfaz {

    private Negocio negocio = new Negocio();


    /**
     * -Lee la cantidad de combustible a cargar en el surtidor por primera vez e inicializa el surtidor, solicita la acción a la capa de negocio.
     * -Indica si la operación fue exitosa o un fracaso (según informa la capa de negocio).
     *
     * pre:
     * post: se inicializa el surtidor e informa si la operacion fue exitosa, en caso contrario informa del fracaso
     */
    public void inicializaSurtidor() {
        double carga = 1000; //simula lectura

        try {
            negocio.Inicializa_Surtidor(carga);
            System.out.println("Surtidor inicializado con éxito");
        } catch (fracasoException e) {
            System.out.println(e.getMessage());
        }
    }



    /**
     * Lee la cantidad de combustible y da la orden a la capa de negocio de cargar en el surtidor.
     * Indica si la operación fue exitosa o un fracaso (según informa la capa de negocio).
     *
     *
     * pre:
     * post: carga el surtidor e informa si la operacion fue exitosa, en caso contrario informa del fracaso
     */
    public void cargarSurtidor() {
        double carga = 100;

        try {
            negocio.cargaSurtidor(carga);
            System.out.println("Se cargó el surtidor con éxito");
        } catch (fracasoException e) {
            System.out.println(e.getMessage());
        }
    }



    /**
     * Se indica a la capa de Negocio que la Manguera1 comienza a descargar combustible (acción del usuario).
     * Indica si la acción es posible o no (según informa la capa de negocio).
     *
     *
     * pre:
     * post: se activa manguera 1 y se informa, en caso contrario se informa del fracaso
     */
    public void activaManguera1() {
        try {
            negocio.activaManguera1();
            System.out.println("operacion exitosa");
        } catch (fracasoException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
    }



    /**
     * Se indica a la capa de Negocio que la Manguera2 comienza a descargar combustible (acción del usuario).
     * Indica si la acción es posible o no (según informa la capa de negocio).
     *
     *
     * pre:
     * post: se activa la manguera 2 y se informa, en caso contrario informa del fracaso
     */
    public void activaManguera2() {
        try {
            negocio.activaManguera2();
            System.out.println("operacion exitosa");
        } catch (fracasoException e) {
            System.out.println(e.getMessage());
        }
    }



    /**
     * Indica a la capa de negocio cuando el usuario detiene la descarga de combustible.
     * Indica que no hay mas combustible cuando le informa la capa de negocio y detiene la descarga automáticamente.
     * Muestra en Pantalla los diferentes acumulados que le informa la capa de negocio.
     *
     * pre:
     * post: se desactiva la manguera 1 y se informan resultados
     */
    public void DesactivaManguera1() {
        try {
            System.out.println(negocio.DesactivaManguera1());
        } catch (DepositoVacioException e) {
            System.out.println(e.getMessage());
        }
    }





    /**
     * Indica a la capa de negocio cuando el usuario detiene la descarga de combustible.
     * Indica que no hay más combustible cuando le informa la capa de negocios y detiene la descarga automáticamente
     * Muestra en pantalla los diferentes acumulados que le informa la capa de negocio.
     *
     * pre:
     * post: se desactiva la manguera 2 y se informan resultados
     */
    public void DesactivaManguera2() {
        try {
            System.out.println(negocio.DesactivaManguera2());
        } catch (DepositoVacioException e) {
            System.out.println(e.getMessage());
        }
    }


















}
