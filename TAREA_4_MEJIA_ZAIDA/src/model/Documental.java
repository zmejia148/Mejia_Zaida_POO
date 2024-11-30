package model;

public class Documental extends ContAudioVisual {
    private String narrador;

    public Documental(String titulo, int duracionEnMinutos, String genero, String narrador) {
        super(titulo, duracionEnMinutos, genero);
        this.narrador = narrador;
    }

    public String getNarrador() {
        return narrador;
    }

    public void setNarrador(String narrador) {
        this.narrador = narrador;
    }

    @Override
    public String obtenerDetalles() {
        return String.format("Documental - ID: %d, Titulo: %s, Duracion: %d mins, Genero: %s, Narrador: %s",
                getId(), getTitulo(), getDuracionEnMinutos(), getGenero(), narrador);
    }

    @Override
    public String toCSV() {
        return "Documental," + getTitulo() + "," + getDuracionEnMinutos() + "," + getGenero() + "," + narrador;
    }
}
