package uni1a;

public class Cortometraje extends ContenidoAudiovisual {
    private String festivalPresentado;

    public Cortometraje(String titulo, int duracionEnMinutos, String genero, String festivalPresentado) {
        super(titulo, duracionEnMinutos, genero);
        this.festivalPresentado = festivalPresentado;
    }

    public String getFestivalPresentado() {
        return festivalPresentado;
    }

    public void setFestivalPresentado(String festivalPresentado) {
        this.festivalPresentado = festivalPresentado;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("====== Detalles del cortometraje: ======");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Festival presentado: " + festivalPresentado);
        System.out.println();
    }
}

