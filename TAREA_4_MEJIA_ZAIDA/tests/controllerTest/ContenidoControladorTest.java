package controllerTest;

import controller.ContenidoControlador;
import model.*;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContenidoControladorTest {
    private ContenidoControlador controlador;
    private String rutaArchivo;

    @BeforeEach
    public void setUp() {
        // Determinar la ruta completa del archivo CSV
        rutaArchivo = System.getProperty("user.dir") + "/contenidos.csv";
        File file = new File(rutaArchivo);

        // Eliminar el archivo CSV si existe para empezar con un entorno limpio
        if (file.exists()) {
            file.delete();
        }

        // Inicializar el controlador
        controlador = new ContenidoControlador();
    }

    @AfterEach
    public void tearDown() {
        // Eliminar el archivo CSV después de cada prueba
        File file = new File(rutaArchivo);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testAgregarContenido() {
        // Crear un contenido
        Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia ficción", "Warner Bros");

        // Agregar contenido al controlador
        controlador.agregarContenido(pelicula);

        // Verificar que el contenido se agregó
        List<ContAudioVisual> contenidos = controlador.obtenerContenidos();
        assertEquals(1, contenidos.size());
        assertEquals("Inception", contenidos.get(0).getTitulo());
    }

    @Test
    public void testEliminarContenido() {
        // Agregar contenido
        Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia ficción", "Warner Bros");
        pelicula.setId(1); // Asignar ID
        controlador.agregarContenido(pelicula);

        // Eliminar contenido
        controlador.eliminarContenido(1);

        // Verificar que la lista está vacía
        List<ContAudioVisual> contenidos = controlador.obtenerContenidos();
        assertTrue(contenidos.isEmpty());
    }

    @Test
    public void testActualizarContenidoGeneral() {
        // Agregar contenido
        Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia ficción", "Warner Bros");
        pelicula.setId(1); // Asignar ID
        controlador.agregarContenido(pelicula);

        // Actualizar contenido
        controlador.actualizarContenido(1, "Interstellar", 169, "Aventura");

        // Verificar que el contenido se actualizó
        List<ContAudioVisual> contenidos = controlador.obtenerContenidos();
        assertEquals(1, contenidos.size());
        ContAudioVisual contenido = contenidos.get(0);
        assertEquals("Interstellar", contenido.getTitulo());
        assertEquals(169, contenido.getDuracionEnMinutos());
        assertEquals("Aventura", contenido.getGenero());
    }

    @Test
    public void testActualizarContenidoDocumental() {
        // Agregar un documental
        Documental documental = new Documental("Planeta Tierra", 50, "Naturaleza", "David Attenborough");
        documental.setId(2); // Asignar ID
        controlador.agregarContenido(documental);

        // Actualizar documental
        controlador.actualizarContenido(2, "Blue Planet", 55, "Naturaleza", "Richard Attenborough");

        // Verificar que el documental se actualizó
        List<ContAudioVisual> contenidos = controlador.obtenerContenidos();
        assertEquals(1, contenidos.size());
        ContAudioVisual contenido = contenidos.get(0);
        assertTrue(contenido instanceof Documental);

        Documental documentalActualizado = (Documental) contenido;
        assertEquals("Blue Planet", documentalActualizado.getTitulo());
        assertEquals(55, documentalActualizado.getDuracionEnMinutos());
        assertEquals("Naturaleza", documentalActualizado.getGenero());
        assertEquals("Richard Attenborough", documentalActualizado.getNarrador());
    }

    @Test
    public void testActualizarContenidoNoExistente() {
        // Intentar actualizar un contenido que no existe
        controlador.actualizarContenido(99, "Titulo inexistente", 100, "Genero inexistente");

        // Verificar que no se agregó contenido accidentalmente
        List<ContAudioVisual> contenidos = controlador.obtenerContenidos();
        assertTrue(contenidos.isEmpty());
    }
}
