/**
 * Class SerieDeTV
 */
package uni1a;
import java.util.ArrayList;
import java.util.List;

// Subclase SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
    private List<Temporada> temporadas;
    private int numeroDeTemporadas;

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int numeroDeTemporadas) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = new ArrayList<>();
        this.numeroDeTemporadas = numeroDeTemporadas;
    }

    public void agregarTemporada(Temporada temporada) {
        temporadas.add(temporada);
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("====== Detalles de la serie de TV: ======");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Número de temporadas: " + numeroDeTemporadas);
        
        for (Temporada temp : temporadas) {
            temp.mostrarInformacion();
        }
        System.out.println();
    }
}
