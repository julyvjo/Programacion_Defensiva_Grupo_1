package modelo;

import excepciones.CertificadoInexistenteException;
import excepciones.LegajoInvalidoException;
import excepciones.NombreMateriaInvalidoException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que representa al sistema de certificados
 *
 * @author GRUPO 1
 */

public class Sistema {

    private ArrayList<Certificado> certificados = new ArrayList<Certificado>();
    private Certificado certificadoActual = null;

    /**
     * Metodo que a partir de un legajo dado, busca en su lista de certificados el correspondiente, y de ser encontrado,
     * actualiza su certificado actual con el pedido.
     *
     * <b>Pre: </b> legajo != null
     * <b>Post: </b> se actualiza certificadoActual con el certificado encontrado.
     *
     * @param legajo: legajo del certificado a buscar
     *
     * @throws LegajoInvalidoException: si el legajo del certificado a pedir no existe
     */
    public void pedirCertificado(Integer legajo) throws LegajoInvalidoException {
        verificarInvariantes();
        Iterator<Certificado> it = certificados.iterator();
        Certificado cert = null;
        while (it.hasNext() && (cert = it.next()).traerLegajo() != legajo ){
        }
        if (cert == null || cert.traerLegajo() != legajo)
            throw new LegajoInvalidoException("El legajo que se pide es invalido");
        else
            certificadoActual = cert;
        verificarInvariantes();
    }

    /**
     * Metodo que devuelve el apellido y nombre del alumno con el certificado que se pidio, estando este ubicado en
     * certificadoActual.
     *
     * <b>Post: </b> devuelve el apellido y nombre del certificado.
     *
     * @return apellido y nombre del certificado.
     *
     * @throws CertificadoInexistenteException: si no se cargo o no existe el certificado pedidio
     */
    public String traerApellidoyNombre() throws CertificadoInexistenteException {
        verificarInvariantes();
        if (certificadoActual == null)
            throw new CertificadoInexistenteException("No se cargó o no existe el certificado pedido");
        return certificadoActual.traerApellidoyNombre();
    }

    /**
     * Metodo que devuelve el estado actual de una materia de un certificado pedido.
     *
     * <b>Pre: </b> materia != null, materia no vacía
     * <b>Post: </b> es devuelto el estado de la materia dada
     *
     * @param materia: nombre de la materia de la cual se requiere saber el estado
     *
     * @return: estado de la materia
     *
     * @throws CertificadoInexistenteException: si el certificado no se cargo o no existe el certificado pedido
     * @throws NombreMateriaInvalidoException: si el nombre de la materia no es uno de los predefinidos
     */
    public String traerEstado(String materia) throws CertificadoInexistenteException, NombreMateriaInvalidoException {
        verificarInvariantes();
        if (certificadoActual == null)
            throw new CertificadoInexistenteException("No se cargó o no existe el certificado pedido");
        return certificadoActual.traerEstado(materia);
    }

    /**
     * Metodo que devuelve la nota de una materia del certificado pedido.
     *
     * <b>Pre: </b> materia != null, materia no vacía
     * <b>Post: </b> se devuelve la nota de la materia dada
     *
     * @param materia: nombre de la materia de la cual se necesita la nota
     *
     * @return nota de la materia
     *
     * @throws CertificadoInexistenteException: si el certificado no se cargo o no existe
     * @throws NombreMateriaInvalidoException: si el nombre de la materia no es uno de los predefinidos
     */
    public String traerNota(String materia) throws CertificadoInexistenteException, NombreMateriaInvalidoException {
        verificarInvariantes();
        if (certificadoActual == null)
            throw new CertificadoInexistenteException("No se cargó o no existe el certificado pedido");
        return certificadoActual.traerNota(materia);
    }

    /**
     * Metodo que devuelve la condicion de un alumno en base a sus materias
     *
     * <b>Post: </b> se devuelve la condicion
     *
     * @return condicion del alumno
     *
     * @throws CertificadoInexistenteException: si no se cargo un certificado o el mismo no existe
     */
    public String traerCondicion() throws CertificadoInexistenteException {
        verificarInvariantes();
        if (certificadoActual == null)
            throw new CertificadoInexistenteException("No se cargó o no existe el certificado pedido");
        return certificadoActual.traerCondicion();
    }

    /**
     * Metodo que verifica las invariantes de clase. Si alguna no se cumple se lanza AssertError
     *
     * <b>Inv: </b>
     * certificados != null
     *
     * No debe haber certificados duplicados en el sistema
     */
    private void verificarInvariantes(){
        assert certificados != null : "Los certificados son null";
        assert verificarDuplicados() : "Hay certificados duplicados";
    }

    /**
     * Metodo que verifica que no haya duplicados de certificados duplicados en el sistema
     *
     * <b>Post: </b> devuelve si hay o no duplicados en el sistema
     *
     * @return true si hay duplicados, false en caso contrario
     */
    private boolean verificarDuplicados(){
        ArrayList<Integer> legajos = new ArrayList<Integer>();
        Iterator<Certificado> it = certificados.iterator();
        Certificado c;
        boolean repetido = false;
        while (it.hasNext() && !repetido){
            c = it.next();
            if (legajos.contains(c.traerLegajo()))
                repetido = true;
            else
                legajos.add(c.traerLegajo());
        }
        return repetido;
    }

}
