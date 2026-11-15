package SEMANA8.vista;

import SEMANA8.controlador.QuinielaControlador;
import SEMANA8.modelo.Partido;
import java.util.ArrayList;
import java.util.Scanner;

public class QuinielaVista {
    private QuinielaControlador controlador;
    private Scanner sc = new Scanner(System.in);

    public void setControlador(QuinielaControlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n===== QUINIELA =====");
            System.out.println("1. Agregar partido (v1)");
            System.out.println("2. Registrar resultado");
            System.out.println("3. Mostrar quiniela");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1: pedirPartido(); break;
                case 2: pedirResultado(); break;
                case 3: mostrarQuiniela(); break;
                case 0: System.out.println("Adios."); break;
                default: System.out.println("Opcion no valida.");
            }
        }
    }

    private void pedirPartido() {
        System.out.print("Equipo local: ");
        String local = sc.nextLine();
        System.out.print("Equipo visitante: ");
        String visitante = sc.nextLine();
        controlador.agregarPartido(local, visitante);
    }

    private void pedirResultado() {
        mostrarQuiniela();
        System.out.print("Indice del partido (0..n-1): ");
        int idx;
        try {
            idx = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Indice no valido.");
            return;
        }
        System.out.print("Resultado (1/X/2): ");
        String res = sc.nextLine().toUpperCase();
        if (controlador.registrarResultado(idx, res)) {
            System.out.println("Resultado guardado.");
        } else {
            System.out.println("Indice fuera de rango.");
        }
    }

    public void mostrarQuiniela() {
        ArrayList<Partido> partidos = controlador.obtenerPartidos();
        if (partidos.isEmpty()) {
            System.out.println("(No hay partidos todavia)");
            return;
        }
        for (int i = 0; i < partidos.size(); i++) {
            System.out.println(i + ": " + partidos.get(i));
        }
    }
}