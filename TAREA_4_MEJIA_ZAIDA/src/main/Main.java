package main;

import controller.ContenidoControlador;
import view.ContenVista;

public class Main {
    public static void main(String[] args) {
        ContenidoControlador controlador = new ContenidoControlador();
        ContenVista vista = new ContenVista(controlador);
        vista.mostrarMenu();
    }
}
