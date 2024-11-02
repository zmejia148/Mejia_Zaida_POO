package uni1a;

import java.util.ArrayList;
import java.util.List;

public class Actor {
    private String nombre;
    private String nacionalidad;
    private List<Pelicula> peliculas; 

    public Actor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.peliculas = new ArrayList<>();
    }

    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public void mostrarDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Nacionalidad: " + nacionalidad);
        System.out.println("Películas:");
        for (Pelicula pelicula : peliculas) {
            System.out.println("  - " + pelicula.getTitulo());
        }
    }
}
