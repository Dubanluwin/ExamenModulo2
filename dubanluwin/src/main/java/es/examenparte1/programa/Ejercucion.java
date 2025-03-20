package es.examenparte1.programa;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.examenparte1.clases.CursoImpl;
import es.examenparte1.clases.Master;

public class Ejercucion {

    private static final Logger logger = LoggerFactory.getLogger(CursoImpl.class);

    public static void main(String[] args) {

        Master master1 = new Master("Desarrollo", 57, 5, false);
        Master master2 = new Master("Hosteleria", 58, 10, true);
        Master master3 = new Master("Manicure", 34, 15, true);

        List<Master> listaMaster = new ArrayList<>();

        listaMaster.add(master1);
        listaMaster.add(master2);
        listaMaster.add(master3);

        for (Master masterDemo2 : listaMaster) {
            if (masterDemo2.isOficial()) {
                logger.info("Los cursos oficiales en esta academia son: " + masterDemo2.getNombre());
            }
        }

        logger.info("El tamanho de la lista de los cursos para este primavera es: " + listaMaster.size());

        logger.info("El curso con el codigo " + listaMaster.get(2).getCodigo()
                + ", esta siendo analizado para saber si es aprobado.");

        for (int i = 0; i < listaMaster.size(); i++) {
            Master masterDemo = listaMaster.get(i);
            if (masterDemo.getCodigo() == 34) {
                logger.info("El curso " + masterDemo.getNombre() + ", con codigo: " + masterDemo.getCodigo()
                        + ", ha sido eliminado porque no fue aprobado.");
                listaMaster.remove(i);

            }
        }

        logger.info("Los cursos totales para este anho son: " + listaMaster.size());

    }

}
