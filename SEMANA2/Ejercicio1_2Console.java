import java.io.Console;

public class Ejercicio1_2Console {

    public static void main(String[] args) {

        Console console = System.console();

        // Si se ejecuta desde un IDE, console será null
        if (console == null) {
            System.err.println("No hay consola disponible. Ejecuta desde una terminal real.");
            System.exit(1);
        }

        // --- Lectura como String ---
        String anioNacStr = console.readLine("Introduce tu año de nacimiento: ");
        String anioActStr = console.readLine("Introduce el año actual: ");

        // --- Conversión String -> int con Integer.parseInt ---
        int anioNacimiento = Integer.parseInt(anioNacStr.trim());
        int anioActual     = Integer.parseInt(anioActStr.trim());

        int edad = anioActual - anioNacimiento;

        // --- Salida formateada ---
        console.printf("Tienes %d años.%n", edad);
        console.printf("Naciste en %d y estamos en %d.%n", anioNacimiento, anioActual);
    }
}
