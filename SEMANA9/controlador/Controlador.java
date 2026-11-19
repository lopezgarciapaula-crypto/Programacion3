package controlador;

import modelo.Libro;
import vista.Vista;
import es.usal.progiii.tools.Rutas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Controlador {

    private Vista vista;
    private List<Libro> libros = new ArrayList<>();

    public Controlador(Vista vista) {
        this.vista = vista;
    }

    // ===== Carga inicial .BIN =====
    public void cargarAlArrancar() {
        File f = Rutas.fileToFileOnDesktop("libros.bin");
        if (f == null || !f.exists()) {
            vista.mensaje("No se encontro libros.bin. Se empieza con lista vacia.");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                libros = (List<Libro>) obj;
            }
            vista.mensaje("Cargados " + libros.size() + " libros desde libros.bin.");
        } catch (Exception e) {
            vista.error("No se pudo leer libros.bin: " + e.getMessage());
        }
    }

    // ===== Guardar al salir .BIN =====
    public void guardarAlSalir() {
        File f = Rutas.fileToFileOnDesktop("libros.bin");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
            oos.writeObject(libros);
            vista.mensaje("Guardados " + libros.size() + " libros en libros.bin.");
        } catch (Exception e) {
            vista.error("No se pudo guardar libros.bin: " + e.getMessage());
        }
    }

    // ===== CRUD =====
    public void mostrar() {
        vista.mostrarTabla(libros);
    }

    public void anadir() {
        Libro l = vista.pedirLibroNuevo();
        if (libros.contains(l)) {
            vista.error("Ya existe un libro con ese ISBN.");
            return;
        }
        libros.add(l);
        vista.mensaje("Libro añadido.");
    }

    public void eliminar() {
        int idx = vista.elegirLibro(libros);
        if (idx < 0 || idx >= libros.size()) {
            vista.mensaje("Cancelado.");
            return;
        }
        libros.remove(idx);
        vista.mensaje("Libro eliminado.");
    }

    public void modificar() {
        int idx = vista.elegirLibro(libros);
        if (idx < 0 || idx >= libros.size()) {
            vista.mensaje("Cancelado.");
            return;
        }
        vista.modificarLibro(libros.get(idx));
        vista.mensaje("Libro modificado.");
    }

    // ===== EXPORTAR CSV =====
    public void exportarCsv() {
        File f = Rutas.fileToFileOnDesktop("libros.csv");
        try (PrintWriter pw = new PrintWriter(f, "UTF-8")) {
            pw.println("ISBN;TITULO;AUTOR;ANIO;PRECIO");
            for (Libro l : libros) pw.println(l.aCsv());
            vista.mensaje("Exportado a: " + f.getAbsolutePath());
        } catch (Exception e) {
            vista.error("Error exportando CSV: " + e.getMessage());
        }
    }

    // ===== EXPORTAR JSON =====
    public void exportarJson() {
        File f = Rutas.fileToFileOnDesktop("libros.json");
        try (PrintWriter pw = new PrintWriter(f, "UTF-8")) {
            pw.println("[");
            for (int i = 0; i < libros.size(); i++) {
                Libro l = libros.get(i);
                pw.println("  {");
                pw.println("    \"isbn\": \"" + esc(l.getIsbn()) + "\",");
                pw.println("    \"titulo\": \"" + esc(l.getTitulo()) + "\",");
                pw.println("    \"autor\": \"" + esc(l.getAutor()) + "\",");
                pw.println("    \"anio\": " + l.getAnio() + ",");
                pw.println("    \"precio\": " + l.getPrecio());
                pw.println("  }" + (i < libros.size() - 1 ? "," : ""));
            }
            pw.println("]");
            vista.mensaje("Exportado a: " + f.getAbsolutePath());
        } catch (Exception e) {
            vista.error("Error exportando JSON: " + e.getMessage());
        }
    }

    private String esc(String s) {
        return s == null ? "" : s.replace("\"", "\\\"");
    }

    // ===== IMPORTAR JSON =====
    public void importarJson() {
        File f = Rutas.fileToFileOnDesktop("libros.json");
        if (f == null || !f.exists()) {
            vista.error("No existe libros.json en el escritorio.");
            return;
        }
        int anadidos = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(f), java.nio.charset.StandardCharsets.UTF_8))) {
            String linea;
            String isbn = null, titulo = null, autor = null;
            int anio = 0;
            double precio = 0.0;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.startsWith("\"isbn\""))   isbn   = valorCadena(linea);
                if (linea.startsWith("\"titulo\"")) titulo = valorCadena(linea);
                if (linea.startsWith("\"autor\""))  autor  = valorCadena(linea);
                if (linea.startsWith("\"anio\""))   anio   = (int) valorNumero(linea);
                if (linea.startsWith("\"precio\"")) precio = valorNumero(linea);

                if (linea.equals("}") || linea.equals("},")) {
                    if (isbn != null) {
                        Libro l = new Libro(isbn, titulo, autor, anio, precio);
                        if (!libros.contains(l)) {
                            libros.add(l);
                            anadidos++;
                        }
                    }
                    isbn = null; titulo = null; autor = null; anio = 0; precio = 0.0;
                }
            }
            vista.mensaje("Importados " + anadidos + " libros desde libros.json.");
        } catch (Exception e) {
            vista.error("Error importando JSON: " + e.getMessage());
        }
    }

    private String valorCadena(String linea) {
        int p = linea.indexOf(':');
        String v = linea.substring(p + 1).trim();
        if (v.endsWith(",")) v = v.substring(0, v.length() - 1);
        v = v.trim();
        if (v.startsWith("\"")) v = v.substring(1);
        if (v.endsWith("\""))   v = v.substring(0, v.length() - 1);
        return v;
    }

    private double valorNumero(String linea) {
        String v = valorCadena(linea).replace(',', '.');
        try { return Double.parseDouble(v); } catch (Exception e) { return 0; }
    }

    // ===== EXPORTAR XML =====
    public void exportarXml() {
        File f = Rutas.fileToFileOnDesktop("libros.xml");
        try (PrintWriter pw = new PrintWriter(f, "UTF-8")) {
            pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            pw.println("<libros>");
            for (Libro l : libros) {
                pw.println("  <libro>");
                pw.println("    <isbn>" + escXml(l.getIsbn()) + "</isbn>");
                pw.println("    <titulo>" + escXml(l.getTitulo()) + "</titulo>");
                pw.println("    <autor>" + escXml(l.getAutor()) + "</autor>");
                pw.println("    <anio>" + l.getAnio() + "</anio>");
                pw.println("    <precio>" + l.getPrecio() + "</precio>");
                pw.println("  </libro>");
            }
            pw.println("</libros>");
            vista.mensaje("Exportado a: " + f.getAbsolutePath());
        } catch (Exception e) {
            vista.error("Error exportando XML: " + e.getMessage());
        }
    }

    private String escXml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }

    // ===== IMPORTAR XML =====
    public void importarXml() {
        File f = Rutas.fileToFileOnDesktop("libros.xml");
        if (f == null || !f.exists()) {
            vista.error("No existe libros.xml en el escritorio.");
            return;
        }
        int anadidos = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(f), java.nio.charset.StandardCharsets.UTF_8))) {
            String linea;
            String isbn = null, titulo = null, autor = null;
            int anio = 0;
            double precio = 0.0;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.startsWith("<isbn>"))   isbn   = valorTag(linea, "isbn");
                if (linea.startsWith("<titulo>")) titulo = valorTag(linea, "titulo");
                if (linea.startsWith("<autor>"))  autor  = valorTag(linea, "autor");
                if (linea.startsWith("<anio>"))   anio   = (int) num(valorTag(linea, "anio"));
                if (linea.startsWith("<precio>")) precio = num(valorTag(linea, "precio"));

                if (linea.equals("</libro>")) {
                    if (isbn != null) {
                        Libro l = new Libro(isbn, titulo, autor, anio, precio);
                        if (!libros.contains(l)) {
                            libros.add(l);
                            anadidos++;
                        }
                    }
                    isbn = null; titulo = null; autor = null; anio = 0; precio = 0.0;
                }
            }
            vista.mensaje("Importados " + anadidos + " libros desde libros.xml.");
        } catch (Exception e) {
            vista.error("Error importando XML: " + e.getMessage());
        }
    }

    private String valorTag(String linea, String tag) {
        String abre  = "<" + tag + ">";
        String cierra = "</" + tag + ">";
        int i = linea.indexOf(abre);
        int j = linea.indexOf(cierra);
        if (i < 0 || j < 0) return "";
        return linea.substring(i + abre.length(), j);
    }

    private double num(String s) {
        try { return Double.parseDouble(s.replace(',', '.')); } catch (Exception e) { return 0; }
    }

    // ===== IMPORTAR CSV =====
    public void importarCsv() {
        File f = Rutas.fileToFileOnDesktop("libros.csv");
        if (f == null || !f.exists()) {
            vista.error("No existe libros.csv en el escritorio.");
            return;
        }
        int anadidos = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(f), java.nio.charset.StandardCharsets.UTF_8))) {
            String linea = br.readLine(); // cabecera
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] p = linea.split(";");
                if (p.length < 5) continue;
                try {
                    Libro l = new Libro(
                        p[0].trim(), p[1].trim(), p[2].trim(),
                        Integer.parseInt(p[3].trim()),
                        Double.parseDouble(p[4].trim().replace(',', '.'))
                    );
                    if (!libros.contains(l)) {
                        libros.add(l);
                        anadidos++;
                    }
                } catch (Exception e) {}
            }
            vista.mensaje("Importados " + anadidos + " libros desde libros.csv.");
        } catch (Exception e) {
            vista.error("Error importando CSV: " + e.getMessage());
        }
    }

    // ===== BUCLE PRINCIPAL =====
    public void ejecutar() {
        cargarAlArrancar();
        boolean salir = false;
        while (!salir) {
            int op = vista.mostrarMenu();
            switch (op) {
                case 1:  mostrar();      break;
                case 2:  anadir();       break;
                case 3:  eliminar();     break;
                case 4:  modificar();    break;
                case 5:  exportarCsv();  break;
                case 6:  exportarJson(); break;
                case 7:  exportarXml();  break;
                case 8:  importarJson(); break;
                case 9:  importarXml();  break;
                case 10: importarCsv();  break;
                case 11:
                    if (vista.confirmarSalida()) {
                        guardarAlSalir();
                        vista.mensaje("Adios.");
                        salir = true;
                    } else {
                        vista.mensaje("Cancelado.");
                    }
                    break;
                default:
                    vista.error("Opcion no valida.");
            }
        }
    }
}