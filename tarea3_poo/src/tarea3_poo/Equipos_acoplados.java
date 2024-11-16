package tarea3_poo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Equipos_acoplados {

    public static List<String[]> acoplamientoEquiposRec(List<String> equipos) {
        List<String[]> enfrentamientos = new ArrayList<>();

        if (equipos.size() == 2) {
            enfrentamientos.add(new String[]{equipos.get(0), equipos.get(1)});
            return enfrentamientos;
        }

        Collections.shuffle(equipos);

        while (equipos.size() >= 2) {
            String equipo1 = equipos.remove(0); 
            String equipo2 = equipos.remove(0); 
            enfrentamientos.add(new String[]{equipo1, equipo2});
        }

        return enfrentamientos;
    }

    public static void generarPartidos(List<String> equipos, String etapa) {
        System.out.println("\nSorteo para la etapa de " + etapa + ":");
        List<String[]> partidos = acoplamientoEquiposRec(equipos);
        int partidoNumero = 1;
        for (String[] partido : partidos) {
            System.out.println("Partido " + partidoNumero + ": " + partido[0] + " vs " + partido[1]);
            partidoNumero++;
        }
    }
}
