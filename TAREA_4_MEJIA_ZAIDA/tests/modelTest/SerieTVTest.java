package modelTest;

import model.SerieDeTV;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SerieTVTest {

    @Test
    public void testConstructor() {
        // Crear un objeto SerieDeTV
        SerieDeTV serie = new SerieDeTV("Breaking Bad", 45, "Drama", 5);

        // Verificar los valores iniciales
        assertEquals("Breaking Bad", serie.getTitulo(), "El título no coincide.");
        assertEquals(45, serie.getDuracionEnMinutos(), "La duración no coincide.");
        assertEquals("Drama", serie.getGenero(), "El género no coincide.");
        assertEquals(5, serie.getTemporadas(), "El número de temporadas no coincide.");
    }

    @Test
    public void testSettersAndGetters() {
        // Crear un objeto SerieDeTV
        SerieDeTV serie = new SerieDeTV("Breaking Bad", 45, "Drama", 5);

        // Actualizar los atributos usando setters
        serie.setTitulo("Better Call Saul");
        serie.setDuracionEnMinutos(50);
        serie.setGenero("Crimen");
        serie.setTemporadas(6);

        // Verificar los valores actualizados
        assertEquals("Better Call Saul", serie.getTitulo(), "El título no se actualizó correctamente.");
        assertEquals(50, serie.getDuracionEnMinutos(), "La duración no se actualizó correctamente.");
        assertEquals("Crimen", serie.getGenero(), "El género no se actualizó correctamente.");
        assertEquals(6, serie.getTemporadas(), "El número de temporadas no se actualizó correctamente.");
    }

    @Test
    public void testObtenerDetalles() {
        // Crear un objeto SerieDeTV
        SerieDeTV serie = new SerieDeTV("Breaking Bad", 45, "Drama", 5);

        // Verificar el formato de los detalles
        String detallesEsperados = "Serie de TV - ID: " + serie.getId() +
                ", Titulo: Breaking Bad, Duracion: 45 mins, Genero: Drama, Temporadas: 5";
        assertEquals(detallesEsperados, serie.obtenerDetalles(), "El método obtenerDetalles no devuelve el formato esperado.");
    }

    @Test
    public void testToCSV() {
        // Crear un objeto SerieDeTV
        SerieDeTV serie = new SerieDeTV("Breaking Bad", 45, "Drama", 5);

        // Verificar el formato CSV
        String csvEsperado = "SerieDeTV,Breaking Bad,45,Drama,5";
        assertEquals(csvEsperado, serie.toCSV(), "El método toCSV no devuelve el formato esperado.");
    }
}
