package controlador;

import modelo.DatosDeAlumno;
import modelo.DatosPersonales;
import modelo.Direccion;
import vista.Vista;
import es.usal.progiii.tools.Rutas;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Controlador {

    private Vista vista;
    private List<DatosDeAlumno> alumnos = new ArrayList<>();

    public Controlador(Vista vista) {
        this.vista = vista;
    }

    // ---- Crear 20 alumnos aleatorios sin NIF repetido ----
    public void crearLista() {
        alumnos.clear();
        Set<String> nifsUsados = new HashSet<>();
        while (alumnos.size() < 20) {
            DatosPersonales dp = DatosPersonales.crearAleatorio();
            if (nifsUsados.contains(dp.getNif())) {
                continue;
            }
            nifsUsados.add(dp.getNif());
            Direccion dir = Direccion.crearAleatoria();
            alumnos.add(new DatosDeAlumno(dp, dir));
        }
        vista.mensaje("Creada lista con 20 alumnos.");
    }

    public void recrear() {
        crearLista();
    }

    public void mostrar() {
        vista.mostrarTabla(alumnos);
    }

    // ---- Opcion 3: exportar datos personales ----
    public void exportarPersonales() {
        File f = Rutas.fileToFileOnDesktop("datos_personales.csv");
        try (PrintWriter pw = new PrintWriter(f, "UTF-8")) {
            pw.println("NOMBRE;APELLIDOS;EDAD;NIF");
            for (DatosDeAlumno a : alumnos) {
                pw.println(a.getPersonales().aCsv());
            }
            vista.mensaje("Exportado a: " + f.getAbsolutePath());
        } catch (Exception e) {
            vista.mensaje("Error exportando: " + e.getMessage());
        }
    }

    // ---- Opcion 4: exportar direcciones ----
    public void exportarDirecciones() {
        File f = Rutas.fileToFileOnDesktop("direcciones.csv");
        try (PrintWriter pw = new PrintWriter(f, "UTF-8")) {
            pw.println("CALLE;NUMERO;PISO;LETRA");
            for (DatosDeAlumno a : alumnos) {
                pw.println(a.getDireccion().aCsv());
            }
            vista.mensaje("Exportado a: " + f.getAbsolutePath());
        } catch (Exception e) {
            vista.mensaje("Error exportando: " + e.getMessage());
        }
    }

    // ---- Bucle principal ----
    public void ejecutar() {
        crearLista();
        boolean salir = false;
        while (!salir) {
            String op = vista.mostrarMenu();
            switch (op.trim().toLowerCase()) {
                case "1":
                    recrear();
                    break;
                case "2":
                    mostrar();
                    break;
                case "3":
                    exportarPersonales();
                    break;
                case "4":
                    exportarDirecciones();
                    break;
                case "q":
                    if (vista.confirmarSalida()) {
                        vista.mensaje("Adios.");
                        salir = true;
                    } else {
                        vista.mensaje("Cancelado.");
                    }
                    break;
                default:
                    vista.mensaje("Opcion no valida.");
            }
        }
    }
}