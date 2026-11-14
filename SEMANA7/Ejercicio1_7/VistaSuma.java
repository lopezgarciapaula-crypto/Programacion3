package SEMANA7.Ejercicio1_7;

import java.util.Scanner;

public class VistaSuma {
    private Scanner scanner;
    private ControladorSuma controlador;

    public VistaSuma() {
        this.scanner = new Scanner(System.in);
    }

    public void setControlador(ControladorSuma controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenuPrincipal() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1.- Leer los números");
        System.out.println("2.- Calcular la suma");
        System.out.println("3.- Mostrar el resultado");
        System.out.println("q.- Salir");
        System.out.print("Opción: ");
    }

    public void pedirYLeerNumeros() {
        System.out.print("Introduce el primer número entero: ");
        int n1 = leerEntero();
        System.out.print("Introduce el segundo número entero: ");
        int n2 = leerEntero();
        controlador.recibirNumeros(n1, n2);
    }

    private int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Entrada no válida. Introduce un número entero: ");
            }
        }
    }

    public void mostrarResultado(int n1, int n2, int res) {
        System.out.println("El resultado de sumar " + n1 + " + " + n2 + " es: " + res);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void iniciarBuclePrincipal() {
        boolean salir = false;
        while (!salir) {
            mostrarMenuPrincipal();
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    pedirYLeerNumeros();
                    break;
                case "2":
                    controlador.solicitarCalculoSuma();
                    break;
                case "3":
                    controlador.solicitarMostrarResultado();
                    break;
                case "q":
                case "Q":
                    salir = true;
                    mostrarMensaje("Saliendo del programa...");
                    break;
                default:
                    mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        }
        scanner.close();
    }
}