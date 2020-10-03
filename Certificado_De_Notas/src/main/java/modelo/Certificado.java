package modelo;

import excepciones.LegajoInvalidoException;
import excepciones.MateriasInvalidasException;
import excepciones.NombreMateriaInvalidoException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que representa un certificado
 *
 * @author GRUPO 1
 */
public class Certificado {

    private String nombre;
    private String apellido;
    private Integer legajo;
    private ArrayList<Materia> materias = new ArrayList<Materia>();

    /**
     * Constructor de la clase
     *
     * <b>Pre: </b>
     * nombre != null, nombre no vacio <br>
     * apellido != null, apellido no vacio <br>
     * legajo != null
     * materias != null
     * <b>Post: </b> se crea una instancia de la clase
     *
     * @param nombre: nombre del alumno
     * @param apellido: apellido del alumno
     * @param legajo: legajo del alumno
     * @param materias: materias del alumno
     *
     * @throws LegajoInvalidoException: si el legajo es incorrecto
     * @throws MateriasInvalidasException: si no hay 4 materias, o alguna de ellas es null o no son las materias predefinidas
     */
    public Certificado(String nombre, String apellido, Integer legajo, ArrayList<Materia> materias) throws LegajoInvalidoException, MateriasInvalidasException {
        if (legajo < 1000 || legajo >= 10000)
            throw new LegajoInvalidoException("El legajo debe ser de 4 cifras");
        if (materias.size() != 4)
            throw new MateriasInvalidasException("La cantidad de materias debe ser 4");
        if (materias.contains(null))
            throw new MateriasInvalidasException("Hay una materia que es null");
        if (!verificaMaterias())
            throw new MateriasInvalidasException("No se incluyó una de las materias predefinidas");
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.materias = materias;
        verificarInvariantes();
    }

    /**
     * Metodo que mediante el recorrido de las materias del alumno, devuelve la condicion del mismo
     *
     * <b>Post: </b> devuelve la condicion del alumno
     *
     * @return "Irregular" si las materias a cursar son >= 2, "Regular" en caso contrario
     */
    public String traerCondicion(){
        verificarInvariantes();
        int acursar = 0;
        Iterator<Materia> it = materias.iterator();
        while (it.hasNext() && acursar < 2){
            if (it.next().getEstado().equals("A Cursar"))
                acursar++;
        }
        if (acursar >= 2)
            return "Irregular";
        else
            return "Regular";
    }

    /**
     * Metodo que devuelve el legajo del certificado
     *
     * <b>Post: </b> devuelve el legajo
     *
     * @return legajo del certificado
     */
    public Integer traerLegajo(){
        verificarInvariantes();
        return this.legajo;
    }

    /**
     * Metodo que devuelve un String con el apellido y nombre del certificado
     *
     * <b>Post: </b> devuelve apellido y nombre del alumno
     *
     * @return apellido y nombre
     */
    public String traerApellidoyNombre(){
        verificarInvariantes();
        return this.apellido + " " + this.nombre;
    }

    /**
     * Metodo que devuelve el estado de una materia dada
     *
     * <b>Pre: </b> materia != null, materia no vacia
     * <b>Post: </b> devuelve el estado de la materia
     *
     * @param materia: nombre de la materia
     *
     * @return estado de la materia
     *
     * @throws NombreMateriaInvalidoException: si el nombre de la materia no es uno de los predefinidos.
     */
    public String traerEstado(String materia) throws NombreMateriaInvalidoException {
        verificarInvariantes();
        return buscarMateria(materia).getEstado();
    }

    /**
     * Metodo que devuelve la nota de una materia dada
     *
     * <b>Pre: </b> materia != null, materia no vacía
     * <b>Post: </b> devuelve la nota de la materia pedida
     *
     * @param materia: nombre de la materia
     *
     * @return nota de la materia
     *
     * @throws NombreMateriaInvalidoException: el nombre de la materia no es uno de los predefinidos
     */
    public String traerNota(String materia) throws NombreMateriaInvalidoException {
        verificarInvariantes();
        return buscarMateria(materia).getNota().toString();
    }

    /**
     * Metodo que busca entre las materias de un certificado una materia dada
     *
     * <b>Pre: </b> materia != null, materia no vacia
     * <b>Post: </b> devuelve la materia correspondiente
     *
     * @param materia: nombre de la materia
     *
     * @return objeto de tipo Materia que coincide con el nombre de la materia dado
     *
     * @throws NombreMateriaInvalidoException: el nombre de la materia no es uno de los predefinidos
     */
    private Materia buscarMateria(String materia) throws NombreMateriaInvalidoException {
        verificarInvariantes();
        Iterator<Materia> it = materias.iterator();
        Materia m = null;
        while (it.hasNext() && !(m = it.next()).getNombre().equals(materia)){
        }
        if (!(m.getNombre().equals(materia)))
            throw new NombreMateriaInvalidoException("La materia ingresada no existe");
        else
            return m;
    }

    /**
     * Metodo que verifica las invariantes de clase. En caso que alguna no se cumpla, lanza AssertError
     *
     * <b>Inv: </b>
     * nombre != null, nombre no vacío
     * apellido != null, apellido no vacio
     * legajo != null, el legajo debe ser de 4 cifras
     * materias != null, ninguna materia debe ser null, debe haber 4 materias: Historia, Matematica, Literatura y Fisica
     */
    private void verificarInvariantes(){
        assert nombre != null : "El nombre es null";
        assert !nombre.equals("") : "El nombre esta vacio";
        assert apellido !=  null : "El apellido es null";
        assert !apellido.equals("") : "El apellido esta vacio";
        assert legajo != null : "El legajo es null";
        assert materias != null : "Materias es null";
        assert (legajo >= 1000 && legajo < 10000) : "El legajo no tiene 4 cifras";
        assert materias.contains(null) : "Una materia es null";
        assert materias.size() == 4 : "Faltan o sobran materias";
        assert verificaMaterias() : "Alguna de las materias predefinidas no se encuentra en la estructura";
    }

    /**
     * Metodo que verifica que las materias que se encuentran en el certificado sean las predefinidas y que las mismas
     * no esten repetidas.
     *
     * <b>Post: </b> devuelve si las materias son todas correctas
     *
     * @return true si las materias son correctas, false en caso contrario
     */
    private boolean verificaMaterias(){
        boolean historia = false, matematica = false, literatura = false, fisica = false, repetida = false;
        String nombre;
        Iterator<Materia> it = materias.iterator();
        while (it.hasNext() && !repetida){
            nombre = it.next().getNombre();
            switch (nombre){
                case "Matematica":
                    if (matematica)
                        repetida = true;
                    else
                        matematica = true;
                    break;
                case "Historia":
                    if (historia)
                        repetida = true;
                    else
                        historia = true;
                    break;
                case "Literatura":
                    if (literatura)
                        repetida = true;
                    else
                        literatura = true;
                    break;
                case "Fisica":
                    if (fisica)
                        repetida = true;
                    else
                        fisica = true;
                    break;
            }
        }
        return historia && matematica && literatura && fisica && !repetida;
    }
}
