package view;

import controller.ContenidoControlador;
import model.*;

import java.util.Scanner;

public class ContenVista {
    private ContenidoControlador controlador;
    private Scanner scanner;

    public ContenVista(ContenidoControlador controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== Menú de Contenidos ===");
            System.out.println("1. Listar Contenidos");
            System.out.println("2. Agregar Contenido");
            System.out.println("3. Eliminar Contenido");
            System.out.println("4. Actualizar Contenido");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    listarContenidos();
                    break;
                case 2:
                    agregarContenido();
                    break;
                case 3:
                    eliminarContenido();
                    break;
                case 4:
                    actualizarContenido();
                    break;
                case 0:
                    System.out.println("¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    public void listarContenidos() {
        System.out.println("\nLista de contenidos:");
        for (ContAudioVisual contenido : controlador.obtenerContenidos()) {
            System.out.println(contenido.obtenerDetalles());
        }
    }

    public void agregarContenido() {
        System.out.println("Agregar nuevo contenido...");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Duración en minutos: ");
        int duracion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer
        System.out.print("Género: ");
        String genero = scanner.nextLine();

        System.out.println("Tipo de contenido:");
        System.out.println("1. Película");
        System.out.println("2. Serie de TV");
        System.out.println("3. Documental");
        System.out.print("Selecciona un tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        switch (tipo) {
            case 1:
                System.out.print("Estudio: ");
                String estudio = scanner.nextLine();
                controlador.agregarContenido(new Pelicula(titulo, duracion, genero, estudio));
                break;
            case 2:
                System.out.print("Número de temporadas: ");
                int temporadas = scanner.nextInt();
                controlador.agregarContenido(new SerieDeTV(titulo, duracion, genero, temporadas));
                break;
            case 3:
                System.out.print("Narrador: ");
                String narrador = scanner.nextLine();
                controlador.agregarContenido(new Documental(titulo, duracion, genero, narrador));
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public void eliminarContenido() {
        System.out.print("Introduce el ID del contenido a eliminar: ");
        int id = scanner.nextInt();
        controlador.eliminarContenido(id);
    }

    public void actualizarContenido() {
        System.out.print("Introduce el ID del contenido a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        System.out.print("Nuevo título: ");
        String nuevoTitulo = scanner.nextLine();

        System.out.print("Nueva duración en minutos: ");
        int nuevaDuracion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        System.out.print("Nuevo género: ");
        String nuevoGenero = scanner.nextLine();

        ContAudioVisual contenido = controlador.obtenerContenidos().stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        if (contenido != null) {
            if (contenido instanceof Documental) {
                System.out.print("Nuevo narrador: ");
                String nuevoNarrador = scanner.nextLine();
                controlador.actualizarContenido(id, nuevoTitulo, nuevaDuracion, nuevoGenero, nuevoNarrador);
            } else {
                controlador.actualizarContenido(id, nuevoTitulo, nuevaDuracion, nuevoGenero);
            }
        } else {
            System.out.println("Contenido con ID " + id + " no encontrado.");
        }
    }
}
