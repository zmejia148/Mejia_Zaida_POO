package model;

public class SerieDeTV extends ContAudioVisual {
    private int temporadas;

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int temporadas) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    @Override
    public String obtenerDetalles() {
        return String.format("Serie de TV - ID: %d, Titulo: %s, Duracion: %d mins, Genero: %s, Temporadas: %d",
                getId(), getTitulo(), getDuracionEnMinutos(), getGenero(), temporadas);
    }

    @Override
    public String toCSV() {
        return "SerieDeTV," + getTitulo() + "," + getDuracionEnMinutos() + "," + getGenero() + "," + temporadas;
    }
}
