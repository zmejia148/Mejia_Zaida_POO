package modelTest;

import model.Pelicula;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PeliculaTest {

    @Test
    public void testConstructor() {
        // Crear un objeto Pelicula
        Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Warner Bros");

        // Verificar los valores iniciales
        assertEquals("Inception", pelicula.getTitulo(), "El título no coincide.");
        assertEquals(148, pelicula.getDuracionEnMinutos(), "La duración no coincide.");
        assertEquals("Ciencia Ficción", pelicula.getGenero(), "El género no coincide.");
        assertEquals("Warner Bros", pelicula.getEstudio(), "El estudio no coincide.");
    }

    @Test
    public void testSettersAndGetters() {
        // Crear un objeto Pelicula
        Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Warner Bros");

        // Actualizar los atributos usando setters
        pelicula.setTitulo("Interstellar");
        pelicula.setDuracionEnMinutos(169);
        pelicula.setGenero("Aventura");
        pelicula.setEstudio("Paramount Pictures");

        // Verificar los valores actualizados
        assertEquals("Interstellar", pelicula.getTitulo(), "El título no se actualizó correctamente.");
        assertEquals(169, pelicula.getDuracionEnMinutos(), "La duración no se actualizó correctamente.");
        assertEquals("Aventura", pelicula.getGenero(), "El género no se actualizó correctamente.");
        assertEquals("Paramount Pictures", pelicula.getEstudio(), "El estudio no se actualizó correctamente.");
    }

    @Test
    public void testObtenerDetalles() {
        // Crear un objeto Pelicula
        Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Warner Bros");

        // Verificar el formato de los detalles
        String detallesEsperados = "Pelicula - ID: " + pelicula.getId() +
                ", Titulo: Inception, Duracion: 148 mins, Genero: Ciencia Ficción, Estudio: Warner Bros";
        assertEquals(detallesEsperados, pelicula.obtenerDetalles(), "El método obtenerDetalles no devuelve el formato esperado.");
    }

    @Test
    public void testToCSV() {
        // Crear un objeto Pelicula
        Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Warner Bros");

        // Verificar el formato CSV
        String csvEsperado = "Pelicula,Inception,148,Ciencia Ficción,Warner Bros";
        assertEquals(csvEsperado, pelicula.toCSV(), "El método toCSV no devuelve el formato esperado.");
    }
}
