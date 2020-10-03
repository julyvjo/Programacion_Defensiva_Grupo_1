package modelo;

import excepciones.EstadoMateriaInvalidoException;
import excepciones.MateriaNoAprobadaException;
import excepciones.NombreMateriaInvalidoException;
import excepciones.NotaInvalidaException;

/**
 * Clase que representa una materia de un alumno
 *
 * @author GRUPO 1
 */
public class Materia {

    private String nombre;
    private String estado;
    private Double nota = null;

    /**
     * Constructor de la clase
     *
     * <b>Pre: </b> nombre != null, nombre != "" <br>
     *     estado != null, estado != "" <br>
     *     nota != null
     *
     * <b>Post: </b> se crea una instancia de la clase Materia
     *
     * @param nombre: nombre de la materia
     * @param estado: estado de la materia
     * @param nota: nota de la materia
     *
     * @throws NombreMateriaInvalidoException: si el nombre de la materia que se quiere ingresar no es uno de los
     * predefinidos
     * @throws EstadoMateriaInvalidoException: si el estado de la materia que se quiere ingresar no es uno de los
     * predefinidos
     * @throws MateriaNoAprobadaException: si el estado de la materia no es aprobado y de todas formas se quiere
     * ingresar una nota (las notas solo son para materias aprobadas)
     * @throws NotaInvalidaException: si la nota que se quiere ingresar no esta comprendida entre 0 y 10
     */

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

    /**
     * Constructor de la clase
     *
     * <b>Pre: </b> nombre != null, nombre != "" <br>
     *        estado != null, estado != ""
     *
     * <b>Post: </b> se crea una instancia de la clase Materia
     *
     * @param nombre: nombre de la materia
     * @param estado: estado de la materia
     *
     * @throws NombreMateriaInvalidoException: si el nombre de la materia que se quiere ingresar no es uno de los
     * predefinidos
     * @throws EstadoMateriaInvalidoException: si el estado de la materia que se quiere ingresar no es uno de los
     * predefinidos
     */
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

    /**
     * Metodo que devuelve el nombre de la materia
     *
     * <b>Post: </b> se devuelve el nombre
     *
     * @return nombre de la materia
     */
    public String getNombre() {
        verificaInvariantes();
        return nombre;
    }

    /**
     * Metodo que devuelve el estado de la materia
     *
     * <b>Post: </b> se devuelve el estado
     *
     * @return estado de la materia
     */
    public String getEstado() {
        verificaInvariantes();
        return estado;
    }

    /**
     * Metodo que devuelve la nota de una materia
     *
     * <b>Post: </b> se devuelve la nota
     *
     * @return nota de la materia
     */
    public Double getNota() {
        verificaInvariantes();
        return nota;
    }

    /**
     * Metodo que setea el estado de la materia a "Aprobado" y guarda la nota
     *
     * <b>Pre: </b> nota != null
     * <b>Post: </b> se setean el estado y la nota
     *
     * @param nota: nota a guardar
     *
     * @throws EstadoMateriaInvalidoException: si la materia no es una de las predefinidas
     * @throws NotaInvalidaException: si la nota no se encuentra en el rango correspondiente
     */
    public void setAprobado(Double nota) throws EstadoMateriaInvalidoException, NotaInvalidaException {
        verificaInvariantes();
        this.estado = "Aprobado";
        if (nota < 0 || nota > 10){
            throw new NotaInvalidaException("La nota debe estar entre 0 y 10");
        }
        this.nota = nota;
        verificaInvariantes();
    }

    /**
     * Metodo que setea el estado de la materia a "Cursada" y setea la nota en null
     *
     * <b>Post: </b> se setearon correctamente el estado y la nota
     */
    public void setCursada(){
        verificaInvariantes();
        estado = "Cursada";
        nota = null;
        verificaInvariantes();
    }

    /**
     * Metodo que setea el estado de la materia a "A Cursar" y setea la nota en null
     *
     * <b>Post: </b> se setearon correctamente el estado y la nota
     */
    public void setACursar(){
        verificaInvariantes();
        estado = "A Cursar";
        nota = null;
        verificaInvariantes();
    }

    /**
     * Metodo que verifica que el nombre de la materia sea correcto
     *
     * <b>Pre: </b> nombre != null
     * <b>Post: </b> devuelve un boolean que determina si el nombre es correcto
     *
     * @param nombre: nombre de la materia
     *
     * @return true si es correcto, false en caso contrario
     */
    private boolean verificaNombre(String nombre){
        return nombre.equals("Matematica") || nombre.equals("Historia") || nombre.equals("Fisica") || nombre.equals("Literatura");
    }

    /**
     * Metodo que verifica que el estado de la materia sea correcto
     *
     * <b>Pre: </b> estado != null
     * <b>Post: </b> devuelve un boolean que determina si el estado es correcto
     *
     * @param estado: estado de la materia
     *
     * @return true si es correcto, false en caso contrario
     */
    private boolean verificaEstado(String estado){
        return estado.equals("A Cursar") || estado.equals("Cursada") || estado.equals("Aprobada");
    }

    /**
     * Metodo que verifica las invariantes de clase. Si alguna no se cumple, lanza AssertError
     *
     * <b>Inv: </b>
     * nombre != null, nombre no vacio <br>
     * estado != null, estado no vacio <br>
     *
     * nombre igual a Matematica o Historia o Literatura o Fisica <br>
     * estado igual a A Cursar o Cursada o Aprobada <br>
     *
     * si el estado es Aprobada, nota != null y 0 <= nota <= 10 <br>
     * si el estado es Cursada o A Cursar, nota == null
     */
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
