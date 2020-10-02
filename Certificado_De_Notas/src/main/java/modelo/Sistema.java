package modelo;

import excepciones.CertificadoInexistenteException;
import excepciones.LegajoInvalidoException;
import excepciones.NombreMateriaInvalidoException;

import java.util.ArrayList;
import java.util.Iterator;

public class Sistema {

    private ArrayList<Certificado> certificados = new ArrayList<Certificado>();
    private Certificado certificadoActual = null;

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

    public String traerApellidoyNombre() throws CertificadoInexistenteException {
        verificarInvariantes();
        if (certificadoActual == null)
            throw new CertificadoInexistenteException("No se cargó o no existe el certificado pedido");
        return certificadoActual.traerApellidoyNombre();
    }

    public String traerEstado(String materia) throws CertificadoInexistenteException, NombreMateriaInvalidoException {
        verificarInvariantes();
        if (certificadoActual == null)
            throw new CertificadoInexistenteException("No se cargó o no existe el certificado pedido");
        return certificadoActual.traerEstado(materia);
    }

    public String traerNota(String materia) throws CertificadoInexistenteException, NombreMateriaInvalidoException {
        verificarInvariantes();
        if (certificadoActual == null)
            throw new CertificadoInexistenteException("No se cargó o no existe el certificado pedido");
        return certificadoActual.traerNota(materia);
    }

    public String traerCondicion() throws CertificadoInexistenteException {
        verificarInvariantes();
        if (certificadoActual == null)
            throw new CertificadoInexistenteException("No se cargó o no existe el certificado pedido");
        return certificadoActual.traerCondicion();
    }

    private void verificarInvariantes(){
        assert certificados != null : "Los certificados son null";
        assert verificarDuplicados() : "Hay certificados duplicados";
    }

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
