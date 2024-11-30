package model;

public class Pelicula extends ContAudioVisual {
    private String estudio;

    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    @Override
    public String obtenerDetalles() {
        return String.format("Pelicula - ID: %d, Titulo: %s, Duracion: %d mins, Genero: %s, Estudio: %s",
                getId(), getTitulo(), getDuracionEnMinutos(), getGenero(), estudio);
    }

    @Override
    public String toCSV() {
        return "Pelicula," + getTitulo() + "," + getDuracionEnMinutos() + "," + getGenero() + "," + estudio;
    }

}
