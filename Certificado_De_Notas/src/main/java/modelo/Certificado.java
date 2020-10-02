package modelo;

import excepciones.LegajoInvalidoException;
import excepciones.MateriasInvalidasException;
import excepciones.NombreMateriaInvalidoException;

import java.util.ArrayList;
import java.util.Iterator;

public class Certificado {

    private String nombre;
    private String apellido;
    private Integer legajo;
    private ArrayList<Materia> materias = new ArrayList<Materia>();

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

    public Integer traerLegajo(){
        verificarInvariantes();
        return this.legajo;
    }

    public String traerApellidoyNombre(){
        verificarInvariantes();
        return this.apellido + " " + this.nombre;
    }

    public String traerEstado(String materia) throws NombreMateriaInvalidoException {
        verificarInvariantes();
        return buscarMateria(materia).getEstado();
    }

    public String traerNota(String materia) throws NombreMateriaInvalidoException {
        verificarInvariantes();
        return buscarMateria(materia).getNota().toString();
    }

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
