package vista;

import controlador.PersonasControlador;
import modelo.Persona;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonasVista {
    private PersonasControlador controlador;
    private Scanner sc;

    public PersonasVista() {
        this.sc = new Scanner(System.in);
    }

    public void setControlador(PersonasControlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenuPrincipal() {
        int opcion = 0;
        do {
            System.out.println("\n--- MENU CRUD ---");
            System.out.println("1. Agregar persona");
            System.out.println("2. Eliminar persona");
            System.out.println("3. Modificar persona");
            System.out.println("4. Listar personas");
            System.out.println("5. Salir");
            opcion = leerEntero("Ingrese una opción: ");

            switch (opcion) {
                case 1: controlador.agregar(); break;
                case 2: controlador.eliminar(); break;
                case 3: controlador.modificar(); break;
                case 4: controlador.listar(); break;
                case 5: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    // --- Métodos de E/S ---
    public String leerString(String mensaje) {
        System.out.print(mensaje + " ");
        return sc.nextLine();
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje + " ");
        while (!sc.hasNextInt()) {
            System.out.print("Por favor, introduce un número válido: ");
            sc.next();
        }
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }

    public double leerDouble(String mensaje) {
        System.out.print(mensaje + " ");
        while (!sc.hasNextDouble()) {
            System.out.print("Por favor, introduce un decimal válido (ej. 1,75): ");
            sc.next();
        }
        double num = sc.nextDouble();
        sc.nextLine();
        return num;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarLista(ArrayList<Persona> personas) {
        if (personas.isEmpty()) {
            System.out.println("No hay personas en la lista.");
        } else {
            for (Persona p : personas) {
                System.out.println(p.getEstadoComoString());
            }
        }
    }
}
