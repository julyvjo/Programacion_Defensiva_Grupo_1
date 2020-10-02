package negocio;

import excepciones.CertificadoInexistenteException;
import excepciones.LegajoInvalidoException;
import excepciones.NombreMateriaInvalidoException;
import modelo.Sistema;

public class Negocio {

    private Sistema sistema = new Sistema();

    public void pedirCertificado(Integer legajo) throws LegajoInvalidoException {
        verificaInvariantes();
        sistema.pedirCertificado(legajo);
        verificaInvariantes();
    }

    public String traerApellidoyNombre() throws CertificadoInexistenteException {
        verificaInvariantes();
        return sistema.traerApellidoyNombre();
    }

    public String traerEstado(String materia) throws CertificadoInexistenteException, NombreMateriaInvalidoException {
        verificaInvariantes();
        return sistema.traerEstado(materia);
    }

    public String traerNota(String materia) throws CertificadoInexistenteException, NombreMateriaInvalidoException {
        verificaInvariantes();
        return sistema.traerNota(materia);
    }

    public String traerCondicion() throws CertificadoInexistenteException {
        verificaInvariantes();
        return sistema.traerCondicion();
    }

    private void verificaInvariantes(){
        assert sistema != null : "El sistema es null";
    }
}
