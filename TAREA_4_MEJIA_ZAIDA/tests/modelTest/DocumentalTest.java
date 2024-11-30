package modelTest;

import model.Documental;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DocumentalTest {

    @Test
    public void testConstructor() {
        // Crear un objeto Documental
        Documental documental = new Documental("Planeta Tierra", 50, "Naturaleza", "David Attenborough");

        // Verificar los valores iniciales
        assertEquals("Planeta Tierra", documental.getTitulo(), "El título no coincide.");
        assertEquals(50, documental.getDuracionEnMinutos(), "La duración no coincide.");
        assertEquals("Naturaleza", documental.getGenero(), "El género no coincide.");
        assertEquals("David Attenborough", documental.getNarrador(), "El narrador no coincide.");
    }

    @Test
    public void testSettersAndGetters() {
        // Crear un objeto Documental
        Documental documental = new Documental("Planeta Tierra", 50, "Naturaleza", "David Attenborough");

        // Actualizar los atributos usando setters
        documental.setTitulo("Blue Planet");
        documental.setDuracionEnMinutos(55);
        documental.setGenero("Ciencia");
        documental.setNarrador("Richard Attenborough");

        // Verificar los valores actualizados
        assertEquals("Blue Planet", documental.getTitulo(), "El título no se actualizó correctamente.");
        assertEquals(55, documental.getDuracionEnMinutos(), "La duración no se actualizó correctamente.");
        assertEquals("Ciencia", documental.getGenero(), "El género no se actualizó correctamente.");
        assertEquals("Richard Attenborough", documental.getNarrador(), "El narrador no se actualizó correctamente.");
    }

    @Test
    public void testObtenerDetalles() {
        // Crear un objeto Documental
        Documental documental = new Documental("Planeta Tierra", 50, "Naturaleza", "David Attenborough");

        // Verificar el formato de los detalles
        String detallesEsperados = "Documental - ID: " + documental.getId() +
                ", Titulo: Planeta Tierra, Duracion: 50 mins, Genero: Naturaleza, Narrador: David Attenborough";
        assertEquals(detallesEsperados, documental.obtenerDetalles(), "El método obtenerDetalles no devuelve el formato esperado.");
    }

    @Test
    public void testToCSV() {
        // Crear un objeto Documental
        Documental documental = new Documental("Planeta Tierra", 50, "Naturaleza", "David Attenborough");

        // Verificar el formato CSV
        String csvEsperado = "Documental,Planeta Tierra,50,Naturaleza,David Attenborough";
        assertEquals(csvEsperado, documental.toCSV(), "El método toCSV no devuelve el formato esperado.");
    }
}
