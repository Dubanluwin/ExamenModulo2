package es.examenparte1.clases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Master extends CursoImpl {

    private boolean oficial;

    private static final Logger logger = LoggerFactory.getLogger(Master.class);

    public Master(String nombre, int codigo, int cuposDisponibles, boolean oficial) {
        super(nombre, codigo, cuposDisponibles);
        this.oficial = oficial;
    }

    public boolean isOficial() {
        return oficial;
    }

    public void setOficial(boolean oficial) {
        this.oficial = oficial;
    }

    @Override
    public void codigoDelCurso() {
        // TODO Auto-generated method stub
        super.codigoDelCurso();
    }

    @Override
    public void cuposDisponiblesCurso() {
        // TODO Auto-generated method stub
        super.cuposDisponiblesCurso();
    }

    @Override
    public void nombreDelCurso() {
        // TODO Auto-generated method stub
        super.nombreDelCurso();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}
