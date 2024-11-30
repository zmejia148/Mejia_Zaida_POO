package modelTest;

import model.ContAudioVisual;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContAudioVisualTest {

    // Clase concreta para pruebas, implementando los métodos abstractos
    static class ContenidoPrueba extends ContAudioVisual {
        public ContenidoPrueba(String titulo, int duracionEnMinutos, String genero) {
            super(titulo, duracionEnMinutos, genero);
        }

        @Override
        public String obtenerDetalles() {
            return "Detalles del contenido de prueba";
        }

        @Override
        public String toCSV() {
            return "Prueba," + getTitulo() + "," + getDuracionEnMinutos() + "," + getGenero();
        }
    }

    @Test
    void testConstructor() {
        ContAudioVisual contenido = new ContenidoPrueba("Título de prueba", 120, "Acción");

        assertEquals(1, contenido.getId(), "El ID inicial debe ser 1.");
        assertEquals("Título de prueba", contenido.getTitulo(), "El título no coincide.");
        assertEquals(120, contenido.getDuracionEnMinutos(), "La duración no coincide.");
        assertEquals("Acción", contenido.getGenero(), "El género no coincide.");
    }

    @Test
    void testSettersAndGetters() {
        ContAudioVisual contenido = new ContenidoPrueba("Inicial", 90, "Drama");

        // Actualizar atributos
        contenido.setTitulo("Nuevo Título");
        contenido.setDuracionEnMinutos(150);
        contenido.setGenero("Comedia");

        // Verificar los cambios
        assertEquals("Nuevo Título", contenido.getTitulo(), "El título no se actualizó correctamente.");
        assertEquals(150, contenido.getDuracionEnMinutos(), "La duración no se actualizó correctamente.");
        assertEquals("Comedia", contenido.getGenero(), "El género no se actualizó correctamente.");
    }

    @Test
    void testObtenerDetalles() {
        ContAudioVisual contenido = new ContenidoPrueba("Título de prueba", 120, "Acción");
        assertEquals("Detalles del contenido de prueba", contenido.obtenerDetalles(), "El método obtenerDetalles no devuelve lo esperado.");
    }

    @Test
    void testToCSV() {
        ContAudioVisual contenido = new ContenidoPrueba("Título de prueba", 120, "Acción");
        assertEquals("Prueba,Título de prueba,120,Acción", contenido.toCSV(), "El método toCSV no devuelve el formato esperado.");
    }

    @Test
    void testIdsUnicos() {
        ContAudioVisual contenido1 = new ContenidoPrueba("Título 1", 100, "Aventura");
        ContAudioVisual contenido2 = new ContenidoPrueba("Título 2", 150, "Terror");

        assertNotEquals(contenido1.getId(), contenido2.getId(), "Los IDs deben ser únicos.");
    }
}
