package poo;
import uni1a.*;

public class PruebaAudioVisual {
    public static void main(String[] args) {
        System.out.println("Hello from Eclipse!\n");

        // Crear instancias de las subclases originales
        ContenidoAudiovisual[] contenidos = new ContenidoAudiovisual[5];
        contenidos[0] = new Pelicula("Avatar", 125, "Accion", "20th Century Studios");
        contenidos[1] = new SerieDeTV("Game of Thrones", 60, "Fantasy", 8);
        contenidos[2] = new Documental("Our Planet", 50, "Nature", "David Attenborough");

        // Crear instancias de las nuevas subclases
        contenidos[3] = new Cortometraje("El Viaje", 15, "Drama", "Cannes");
        contenidos[4] = new VideoYouTube("El Espacio Exterior", 10, "Educación", "SpaceChannel", 500000);

        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
            System.out.println(); 
        }

        Actor actor1 = new Actor("Leonardo DiCaprio", "Estados Unidos");
        actor1.agregarPelicula((Pelicula) contenidos[0]); 

        Temporada temporada1 = new Temporada(1, 10);
        ((SerieDeTV) contenidos[1]).agregarTemporada(temporada1); // temporada a Game of Thrones primera temporada 

        Investigador investigador1 = new Investigador("Carl Sagan", "Astronomo");
        investigador1.agregarDocumental((Documental) contenidos[2]); 

        System.out.println("===== Detalles del Actor: ===== ");
        actor1.mostrarDetalles();

        System.out.println("\n\n ===== Detalles de la Temporada de Game of Thrones: =====");
        temporada1.mostrarInformacion();

        System.out.println("\n\n===== Detalles del Investigador: =====");
        investigador1.mostrarDetalles();
    }
}
