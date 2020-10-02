package modelo;

import excepciones.EstadoMateriaInvalidoException;
import excepciones.MateriaNoAprobadaException;
import excepciones.NombreMateriaInvalidoException;
import excepciones.NotaInvalidaException;

public class Materia {

    private String nombre;
    private String estado;
    private Double nota = null;

    public Materia(String nombre, String estado, Double nota) throws NombreMateriaInvalidoException, EstadoMateriaInvalidoException, MateriaNoAprobadaException, NotaInvalidaException {
        if (!verificaEstado(estado)){
            throw new EstadoMateriaInvalidoException("El estado ingresado para la materia es invalido");
        }
        if (!estado.equals("Aprobada")){
            throw new MateriaNoAprobadaException("Se quiere ingresar una nota de una materia no aprobada");
        }
        if (nota < 0 || nota > 10){
            throw new NotaInvalidaException("La nota debe estar entre 0 y 10");
        }
        if (!verificaNombre(nombre)){
            throw new NombreMateriaInvalidoException("El nombre ingresado para la materia es invalido");
        }
        this.nombre = nombre;
        this.estado = estado;
        this.nota = nota;
        verificaInvariantes();
    }

    public Materia(String nombre, String estado) throws NombreMateriaInvalidoException, EstadoMateriaInvalidoException {
        if (!verificaEstado(estado)){
            throw new EstadoMateriaInvalidoException("El estado ingresado para la materia es invalido");
        }
        if (!verificaNombre(nombre)){
            throw new NombreMateriaInvalidoException("El nombre ingresado para la materia es invalido");
        }
        this.nombre = nombre;
        this.estado = estado;
        verificaInvariantes();
    }

    public String getNombre() {
        verificaInvariantes();
        return nombre;
    }

    public String getEstado() {
        verificaInvariantes();
        return estado;
    }

    public Double getNota() {
        verificaInvariantes();
        return nota;
    }

    public void setAprobado(Double nota) throws EstadoMateriaInvalidoException, NotaInvalidaException {
        verificaInvariantes();
        this.estado = "Aprobado";
        if (nota < 0 || nota > 10){
            throw new NotaInvalidaException("La nota debe estar entre 0 y 10");
        }
        this.nota = nota;
        verificaInvariantes();
    }

    public void setCursada(){
        verificaInvariantes();
        estado = "Cursada";
        nota = null;
        verificaInvariantes();
    }

    public void setACursar(){
        verificaInvariantes();
        estado = "A Cursar";
        nota = null;
        verificaInvariantes();
    }

    private boolean verificaNombre(String nombre){
        return nombre.equals("Matematica") || nombre.equals("Historia") || nombre.equals("Fisica") || nombre.equals("Literatura");
    }

    private boolean verificaEstado(String estado){
        return estado.equals("A Cursar") || estado.equals("Cursada") || estado.equals("Aprobada");
    }

    private void verificaInvariantes(){
        assert nombre != null : "El nombre es null";
        assert !nombre.equals("") : "El nombre esta vacio";
        assert estado != null : "El estado es null";
        assert !estado.equals("") : "El estado esta vacio";
        assert verificaNombre(nombre) : "Nombre no es correcto";
        assert verificaEstado(estado) : "Estado no es correcto";
        if (estado.equals("Aprobado")) {
            assert nota != null : "La nota es null";
            assert (nota >= 0 && nota <= 10) : "La nota no es valida";
        }
        else{
            assert nota == null : "Un alumno que no tiene la materia aprobada tiene nota";
        }
    }
}
