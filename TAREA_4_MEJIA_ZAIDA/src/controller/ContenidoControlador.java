package controller;

import model.*;
import cargaArchi.ArchivoUtil;
import java.util.List;

public class ContenidoControlador {
    private List<ContAudioVisual> contenidos;

    public ContenidoControlador() {
        contenidos = ArchivoUtil.cargarDesdeCSV();
        System.out.println("Datos cargados desde el archivo CSV. Total de contenidos: " + contenidos.size());
    }

    // Método para agregar un contenido
    public void agregarContenido(ContAudioVisual contenido) {
        contenidos.add(contenido);
        ArchivoUtil.guardarEnCSV(contenidos);  // Guardar automáticamente
        System.out.println("Contenido agregado y guardado automáticamente en el archivo CSV.");
    }

    // Método para obtener los contenidos
    public List<ContAudioVisual> obtenerContenidos() {
        return contenidos;
    }

    // Método para eliminar un contenido
    public void eliminarContenido(int id) {
        contenidos.removeIf(contenido -> contenido.getId() == id);
        ArchivoUtil.guardarEnCSV(contenidos);  // Guardar después de la eliminación
        System.out.println("Contenido con ID " + id + " ha sido eliminado.");
    }

    // Método para actualizar un contenido general (películas, series)
    public void actualizarContenido(int id, String nuevoTitulo, int nuevaDuracion, String nuevoGenero) {
        for (ContAudioVisual contenido : contenidos) {
            if (contenido.getId() == id) {
                contenido.setTitulo(nuevoTitulo);
                contenido.setDuracionEnMinutos(nuevaDuracion);
                contenido.setGenero(nuevoGenero);
                System.out.println("Contenido con ID " + id + " ha sido actualizado.");
                ArchivoUtil.guardarEnCSV(contenidos);  // Guardar después de la actualización
                return;
            }
        }
        System.out.println("Contenido con ID " + id + " no encontrado.");
    }

    // Método para actualizar un documental
    public void actualizarContenido(int id, String nuevoTitulo, int nuevaDuracion, String nuevoGenero, String nuevoNarrador) {
        for (ContAudioVisual contenido : contenidos) {
            if (contenido.getId() == id) {
                contenido.setTitulo(nuevoTitulo);
                contenido.setDuracionEnMinutos(nuevaDuracion);
                contenido.setGenero(nuevoGenero);
                if (contenido instanceof Documental) {
                    ((Documental) contenido).setNarrador(nuevoNarrador);  // Actualizar narrador para los documentales
                }
                System.out.println("Contenido con ID " + id + " ha sido actualizado.");
                ArchivoUtil.guardarEnCSV(contenidos);  // Guardar después de la actualización
                return;
            }
        }
        System.out.println("Contenido con ID " + id + " no encontrado.");
    }
}

