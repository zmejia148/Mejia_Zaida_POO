package uni1a;

public class VideoYouTube extends ContenidoAudiovisual {
    private String canal;
    private int numeroVistas;

    public VideoYouTube(String titulo, int duracionEnMinutos, String genero, String canal, int numeroVistas) {
        super(titulo, duracionEnMinutos, genero);
        this.canal = canal;
        this.numeroVistas = numeroVistas;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public int getNumeroVistas() {
        return numeroVistas;
    }

    public void setNumeroVistas(int numeroVistas) {
        this.numeroVistas = numeroVistas;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("====== Detalles del video de YouTube: ======");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Canal: " + canal);
        System.out.println("Número de vistas: " + numeroVistas);
        System.out.println();
    }
}
