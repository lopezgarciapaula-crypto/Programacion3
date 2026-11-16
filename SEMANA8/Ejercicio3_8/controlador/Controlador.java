package controlador;

import modelo.Persona;
import vista.Vista;
import es.usal.progiii.tools.Rutas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Controlador {

    private Vista vista;
    private List<Persona> personas = new ArrayList<>();

    public Controlador(Vista vista) {
        this.vista = vista;
    }

    // ---- Carga inicial: datos.txt ----
    public void cargarAlArrancar() {
        File fichero = Rutas.fileToFileOnDesktop("datos.txt");
        if (fichero == null || !fichero.exists()) {
            vista.mensaje("No se encontro datos.txt. No se cargaron datos.");
            return;
        }
        int n = leerFichero(fichero);
        vista.mensaje("Cargadas " + n + " personas desde datos.txt.");
    }

    // ---- Opcion 1: importar TSV ----
    public void importar() {
        String nombre = vista.pedirFichero();
        if (nombre == null || nombre.trim().isEmpty()) {
            vista.mensaje("Nombre vacio. Cancelado.");
            return;
        }
        File fichero = Rutas.fileToFileOnDesktop(nombre.trim());
        if (fichero == null || !fichero.exists()) {
            vista.mensaje("El fichero no existe en el escritorio.");
            return;
        }
        int n = leerFichero(fichero);
        vista.mensaje("Importadas " + n + " personas.");
    }

    // ---- Auxiliar: leer lineas TSV ----
    private int leerFichero(File fichero) {
        int contador = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] partes = linea.split("\t");
                if (partes.length < 3) continue;
                try {
                    String nombre = partes[0].trim();
                    String telefono = partes[1].trim();
                    double peso = Double.parseDouble(partes[2].trim().replace(',', '.'));
                    personas.add(new Persona(nombre, telefono, peso));
                    contador++;
                } catch (NumberFormatException e) {
                    // probable cabecera o linea invalida: se ignora
                }
            }
            br.close();
        } catch (Exception e) {
            vista.mensaje("Error leyendo fichero: " + e.getMessage());
        }
        return contador;
    }

    // ---- Opcion 2: mostrar tabla ----
    public void mostrar() {
        vista.mostrarTabla(personas);
    }

    // ---- Bucle principal ----
    public void ejecutar() {
        cargarAlArrancar();
        boolean salir = false;
        while (!salir) {
            int op = vista.mostrarMenu();
            if (op == 1) {
                importar();
            } else if (op == 2) {
                mostrar();
            } else if (op == 3) {
                if (vista.confirmarSalida()) {
                    vista.mensaje("Adios.");
                    salir = true;
                } else {
                    vista.mensaje("Cancelado.");
                }
            } else {
                vista.mensaje("Opcion no valida.");
            }
        }
    }
}