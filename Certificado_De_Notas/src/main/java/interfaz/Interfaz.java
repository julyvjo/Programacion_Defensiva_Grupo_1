package interfaz;

import excepciones.CertificadoInexistenteException;
import excepciones.LegajoInvalidoException;
import excepciones.NombreMateriaInvalidoException;
import negocio.Negocio;

public class Interfaz {

    private Negocio negocio = new Negocio();

    public void pedirCertificado(Integer legajo){
        verificaInvariantes();
        try {
            negocio.pedirCertificado(legajo);
        } catch (LegajoInvalidoException e) {
            mostrarEstado(e.getMessage());
        }
        verificaInvariantes();
    }

    public void mostrarEstado(String mensaje){
        verificaInvariantes();
        System.out.println(mensaje);
        verificaInvariantes();
    }

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

    private void verificaInvariantes(){
        assert negocio != null : "El negocio es null";
    }

}
