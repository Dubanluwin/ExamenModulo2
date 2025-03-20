package es.examenparte2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.examenparte1.clases.CursoImpl;

public class LecturaFichero {

    private static final Logger logger = LoggerFactory.getLogger(CursoImpl.class);

    public static void main(String[] args) {

        Path path = Paths.get("./ficheros/FicheroEjercicio2.txt");
        StringBuilder sb = new StringBuilder();
        int contadorLineas = 0;
        int contadorPalabra = 0;
        HashMap<Integer, String> mapa = new HashMap<>();

        try {

            List<String> lines = Files.readAllLines(path);
            for (String linea : lines) {
                contadorLineas++;
                sb.append(linea).append("\n");

                String[] palabras = linea.split(",");
                // asdasd asdas Quijote! asdd asdasd Quijote asda asd Quijote
                for (String palabra : palabras) {
                    if (palabra.toLowerCase().contains("java")) {
                        contadorPalabra++;
                    }
                }

                mapa.put(contadorLineas, linea);
                Set<Integer> lineas = mapa.keySet();
                for (Integer linecita : lineas) {
                    String contenido = mapa.get(linecita);
                    if (contenido.contains("java")) {
                        logger.info("" + contenido.lines());
                    }
                }

            }

            logger.info(sb.toString());

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        logger.info("Numeros de lineas que contiene el fichero: " + contadorLineas);
        logger.info("Numeros de veces que aparece la palabra java:" + contadorPalabra);

    }

}
