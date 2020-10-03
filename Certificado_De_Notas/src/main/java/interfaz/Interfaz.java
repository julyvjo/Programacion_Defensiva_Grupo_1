package interfaz;

import excepciones.CertificadoInexistenteException;
import excepciones.LegajoInvalidoException;
import excepciones.NombreMateriaInvalidoException;
import negocio.Negocio;

/**
 * Clase que representa a la capa de interfaz
 *
 * @author: GRUPO 1
 */
public class Interfaz {

    private Negocio negocio = new Negocio();

    /**
     * Metodo que pide un certificado a la capa de negocio
     *
     * <b>Post:</b> se cargo en el sistema de la capa de modelo el certificado pedido. En caso de fallo se muestra el mensaje
     * de fallo de la excepcion LegajoInvalidoException.
     *
     * @param legajo: legajo del certificado a pedir
     */
    public void pedirCertificado(Integer legajo){
        verificaInvariantes();
        try {
            negocio.pedirCertificado(legajo);
        } catch (LegajoInvalidoException e) {
            mostrarEstado(e.getMessage());
        }
        verificaInvariantes();
    }

    /**
     * Método que muestra un mensaje de error por pantalla
     *
     *<b>Post: </b> el mensaje fue mostrado
     *
     * @param mensaje: mensaje a mostrar por pantalla
     */
    public void mostrarEstado(String mensaje){
        verificaInvariantes();
        System.out.println(mensaje);
        verificaInvariantes();
    }

    /**
     * Método que muestra los datos del certificado pedido con anterioridad, pidiendo los datos correspondientes a la
     * capa de negocio
     *
     * <b>Post: </b> se muestra con exito los datos del certificado. En caso de fallo, se muestran los mensajes de cualquiera
     * de las excepciones correspondientes: CertificadoInexistenteException o NombreMateriaInvalidoException.
     */
    public void mostrarCertificado(){
        verificaInvariantes();
        try {
            System.out.println("Apellido y nombre: " + negocio.traerApellidoyNombre());
            String materia = "Historia";
            String estado = negocio.traerEstado(materia);
            String nota = "-";
            if (estado.equals("Aprobado"))
                nota = negocio.traerNota(materia);
            System.out.println("Materia: " + materia + ", Estado: " + estado + ", Nota: " + nota);
            materia = "Literatura";
            estado = negocio.traerEstado(materia);
            nota = "-";
            if (estado.equals("Aprobado"))
                nota = negocio.traerNota(materia);
            System.out.println("Materia: " + materia + ", Estado: " + estado + ", Nota: " + nota);
            materia = "Matematica";
            estado = negocio.traerEstado(materia);
            nota = "-";
            if (estado.equals("Aprobado"))
                nota = negocio.traerNota(materia);
            System.out.println("Materia: " + materia + ", Estado: " + estado + ", Nota: " + nota);
            materia = "Fisica";
            estado = negocio.traerEstado(materia);
            nota = "-";
            if (estado.equals("Aprobado"))
                nota = negocio.traerNota(materia);
            System.out.println("Materia: " + materia + ", Estado: " + estado + ", Nota: " + nota);
            System.out.println("Condicion: " + negocio.traerCondicion());
        } catch (CertificadoInexistenteException e) {
            mostrarEstado(e.getMessage());
        } catch (NombreMateriaInvalidoException e) {
            mostrarEstado(e.getMessage());
        }
        verificaInvariantes();
    }

    /**
     * Metodo que verifica que se cumpla la invariante de clase. Si no se cumple lanza AssertError
     *
     * <b> Inv: </b> <br>
     * negocio != null
     */
    private void verificaInvariantes(){
        assert negocio != null : "El negocio es null";
    }


}
