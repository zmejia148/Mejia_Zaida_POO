package uni1a;

import java.util.ArrayList;
import java.util.List;

public class Investigador {
    private String nombre;
    private String especialidad;
    private List<Documental> documentales;

    public Investigador(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.documentales = new ArrayList<>();
    }

    public void agregarDocumental(Documental documental) {
        documentales.add(documental);
    }

    public void mostrarDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Documentales:");
        for (Documental documental : documentales) {
            System.out.println("  - " + documental.getTitulo());
        }
    }
}
