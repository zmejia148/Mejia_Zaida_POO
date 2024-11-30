package cargaArchi;

import model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUtil {
    private static final String ARCHIVO_CSV = "contenidos.csv";

    public static void guardarEnCSV(List<ContAudioVisual> contenidos) {
        try (FileWriter writer = new FileWriter(ARCHIVO_CSV)) {
            for (ContAudioVisual contenido : contenidos) {
                writer.write(contenido.toCSV() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo CSV: " + e.getMessage());
        }
    }

    public static List<ContAudioVisual> cargarDesdeCSV() {
        List<ContAudioVisual> contenidos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_CSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length >= 4) {
                    String tipo = campos[0];
                    String titulo = campos[1];
                    int duracion = Integer.parseInt(campos[2]);
                    String genero = campos[3];

                    // Verificar el tipo y crear el contenido correspondiente
                    if (tipo.equals("Pelicula")) {
                        String estudio = campos[4];
                        contenidos.add(new Pelicula(titulo, duracion, genero, estudio));
                    } else if (tipo.equals("Serie de TV")) {
                        int temporadas = Integer.parseInt(campos[4]);
                        contenidos.add(new SerieDeTV(titulo, duracion, genero, temporadas));
                    } else if (tipo.equals("Documental")) {
                        String narrador = campos[4];
                        contenidos.add(new Documental(titulo, duracion, genero, narrador));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo CSV: " + e.getMessage());
        }
        return contenidos;
    }
}
