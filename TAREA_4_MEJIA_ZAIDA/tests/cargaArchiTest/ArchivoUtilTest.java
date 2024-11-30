package cargaArchiTest;

import cargaArchi.ArchivoUtil;
import model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArchivoUtilTest {
    private static final String ARCHIVO_CSV = "contenidos.csv";

    @BeforeEach
    public void setUp() {
        // Asegurar que el archivo CSV no exista antes de cada prueba
        File file = new File(ARCHIVO_CSV);
        if (file.exists()) {
            file.delete();
        }
    }

    @AfterEach
    public void tearDown() {
        // Eliminar el archivo CSV después de cada prueba
        File file = new File(ARCHIVO_CSV);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testGuardarYcargarEnCSV() {
        // Crear datos de prueba
        List<ContAudioVisual> contenidos = new ArrayList<>();
        contenidos.add(new Pelicula("Inception", 148, "Ciencia ficción", "Warner Bros"));
        contenidos.add(new SerieDeTV("Breaking Bad", 62, "Drama", 5));
        contenidos.add(new Documental("Planeta Tierra", 50, "Naturaleza", "David Attenborough"));

        // Guardar en el archivo CSV
        ArchivoUtil.guardarEnCSV(contenidos);

        // Verificar que el archivo fue creado
        File file = new File(ARCHIVO_CSV);
        assertTrue(file.exists(), "El archivo CSV no fue creado correctamente.");

        // Cargar los datos desde el archivo CSV
        List<ContAudioVisual> contenidosCargados = ArchivoUtil.cargarDesdeCSV();

        // Verificar que los datos cargados sean correctos
        assertEquals(contenidos.size(), contenidosCargados.size(), "El número de contenidos no coincide.");
        
        for (int i = 0; i < contenidos.size(); i++) {
            ContAudioVisual esperado = contenidos.get(i);
            ContAudioVisual cargado = contenidosCargados.get(i);

            assertEquals(esperado.toString(), cargado.toString(), "El contenido cargado no coincide con el esperado.");
        }
    }

    @Test
    public void testCargarDesdeCSVConArchivoInexistente() {
        // Intentar cargar desde un archivo inexistente
        List<ContAudioVisual> contenidos = ArchivoUtil.cargarDesdeCSV();

        // Verificar que la lista esté vacía
        assertNotNull(contenidos, "La lista de contenidos no debería ser nula.");
        assertTrue(contenidos.isEmpty(), "La lista de contenidos debería estar vacía.");
    }
}
