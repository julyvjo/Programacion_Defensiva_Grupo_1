package negocio;

import excepciones.CertificadoInexistenteException;
import excepciones.LegajoInvalidoException;
import excepciones.NombreMateriaInvalidoException;
import modelo.Sistema;

/**
 * Clase que representa a la capa negocio
 *
 * @author GRUPO 1
 */
public class Negocio {

    private Sistema sistema = new Sistema();

    /**
     * Metodo que le pasa al metodo pedirCertificado de la capa del modelo el legajo
     *
     * <b>Post: </b> se pasa el legajo al metodo de la capa del modelo
     *
     * @param legajo: legajo del certificado
     *
     * @throws LegajoInvalidoException: si no existe certificado con tal legajo
     */
    public void pedirCertificado(Integer legajo) throws LegajoInvalidoException {
        verificaInvariantes();
        sistema.pedirCertificado(legajo);
        verificaInvariantes();
    }

    /**
     * Metodo que pide a la capa del modelo el nombre y apellido del certificado pedido
     *
     * <b>Post: </b> devuelve el nombre y apellido proveniente del modelo
     *
     * @return nombre y apellido del certificado
     *
     * @throws CertificadoInexistenteException: si el certificado es null o no existe tal certificado
     */
    public String traerApellidoyNombre() throws CertificadoInexistenteException {
        verificaInvariantes();
        return sistema.traerApellidoyNombre();
    }

    /**
     * Metodo que pide a la capa del modelo el estado de la materia dada
     *
     * <b>Post: </b> devuelve el estado de la materia
     *
     * @param materia: nombre de la materia
     *
     * @return estado de la materia
     *
     * @throws CertificadoInexistenteException: si el certificado es null o no existe tal certificado
     * @throws NombreMateriaInvalidoException: si el nombre de la materia no es uno de los predefinidos
     */
    public String traerEstado(String materia) throws CertificadoInexistenteException, NombreMateriaInvalidoException {
        verificaInvariantes();
        return sistema.traerEstado(materia);
    }

    /**
     * Metodo que pide la nota de una materia a la capa del modelo
     *
     * <b>Post: </b> devuelve la nota de la materia
     *
     * @param materia: nombre de la materia
     *
     * @return nota de la materia
     *
     * @throws CertificadoInexistenteException: si el certificado es null o no existe tal certificado
     * @throws NombreMateriaInvalidoException: si el nombre de la materia no es uno de los predefinidos
     */
    public String traerNota(String materia) throws CertificadoInexistenteException, NombreMateriaInvalidoException {
        verificaInvariantes();
        return sistema.traerNota(materia);
    }

    /**
     * Metodo que pide la condicion del certificado pedido a la capa del modelo
     *
     * <b>Post: </b> devuelve la condicion del certificado
     *
     * @return condicion del certificado
     *
     * @throws CertificadoInexistenteException: si el certificado es null o no existe tal certificado
     */
    public String traerCondicion() throws CertificadoInexistenteException {
        verificaInvariantes();
        return sistema.traerCondicion();
    }

    /**
     * Metodo que verifica la invariante de clase. En caso de no cumplirse, lanza un AssertError
     *
     * <b>Inv: </b>
     * sistema != null
     */
    private void verificaInvariantes(){
        assert sistema != null : "El sistema es null";
    }
}
