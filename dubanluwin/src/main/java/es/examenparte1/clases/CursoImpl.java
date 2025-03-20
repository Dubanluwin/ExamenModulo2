package es.examenparte1.clases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.examenparte1.interfaces.Curso;

public class CursoImpl implements Curso {

    private static final Logger logger = LoggerFactory.getLogger(CursoImpl.class);

    private String nombre;
    private int codigo;
    private int cuposDisponibles;

    public CursoImpl(String nombre, int codigo, int cuposDisponibles) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cuposDisponibles = cuposDisponibles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }

    @Override
    public void nombreDelCurso() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nombreDelCurso'");
    }

    @Override
    public void codigoDelCurso() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'codigoDelCurso'");
    }

    @Override
    public void cuposDisponiblesCurso() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cuposDisponiblesCurso'");
    }

    @Override
    public String toString() {
        return "CursoImpl [nombre=" + nombre + ", codigo=" + codigo + ", cuposDisponibles=" + cuposDisponibles + "]";
    }

}
