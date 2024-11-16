package tarea3_poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Equipos_futbol {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] etapas = { "octavos", "cuartos", "semifinales", "final" };
        int[] numEquipos = { 16, 8, 4, 2 };

        while (true) {
            System.out.println("Seleccione la etapa en la que se encuentra:");
            for (int i = 0; i < etapas.length; i++) {
                System.out.println((i + 1) + ". " + etapas[i]);
            }
            System.out.print("Ingrese el número de la etapa que desea: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            if (opcion < 1 || opcion > etapas.length) {
                System.out.println("\n**!ERROR¡ Opción no válida. Inténtalo de nuevo.**\n");
                continue;
            }

            String etapa = etapas[opcion - 1];
            int numEquiposEtapa = numEquipos[opcion - 1];

            List<String> equipos = new ArrayList<>();
            for (int i = 1; i <= numEquiposEtapa; i++) {
                System.out.print("Ingrese el nombre del equipo " + i + ": ");
                equipos.add(scanner.nextLine());
            }

            Equipos_acoplados.generarPartidos(equipos, etapa);

            System.out.print("¿Desea calcular el factorial del número de equipos en esta etapa? (s/n): ");
            String calcularFactorial = scanner.nextLine().toLowerCase();
            if (calcularFactorial.equals("s")) {
                System.out.println("Calculo con Factorial while: " + Calculo_fac.facWhile(numEquiposEtapa));
                System.out.println("Calculado con recursividad: " + Calculo_fac.facEquiposRec(numEquiposEtapa));
            }

            System.out.print("¿Desea organizar otra etapa? (s/n): ");
            String continuar = scanner.nextLine().toLowerCase();
            if (!continuar.equals("s")) {
                break;
            }
        }
        scanner.close();
    }
}
