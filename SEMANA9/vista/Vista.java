package vista;

import modelo.Libro;
import es.usal.progiii.tools.Esdia;
import es.usal.progiii.tools.OpMat;

import java.util.List;

public class Vista {

    public void mensaje(String texto) {
        System.out.println(texto);
    }

    public void error(String texto) {
        System.out.println("[ERROR] " + texto);
    }

    public int mostrarMenu() {
        System.out.println("\n===== LIBROS =====");
        System.out.println("1. Mostrar listado de libros");
        System.out.println("2. Añadir nuevo libro");
        System.out.println("3. Eliminar libro");
        System.out.println("4. Modificar libro");
        System.out.println("5. Exportar CSV");
        System.out.println("6. Exportar JSON");
        System.out.println("7. Exportar XML");
        System.out.println("8. Importar JSON");
        System.out.println("9. Importar XML");
        System.out.println("10. Importar CSV");
        System.out.println("11. Salir");
        return Esdia.readInt("Elige opcion: ");
    }

    public boolean confirmarSalida() {
        return Esdia.siOno("Seguro que quieres salir? (s/n): ");
    }

    public void mostrarTabla(List<Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println("(No hay libros)");
            return;
        }
        String[][] tabla = new String[libros.size() + 1][];
        tabla[0] = Libro.cabecera();
        for (int i = 0; i < libros.size(); i++) {
            tabla[i + 1] = libros.get(i).aFila();
        }
        OpMat.printToScreen(tabla);
    }

    public Libro pedirLibroNuevo() {
        String isbn   = Esdia.readString("ISBN: ");
        String titulo = Esdia.readString("Titulo: ");
        String autor  = Esdia.readString("Autor: ");
        int anio      = Esdia.readInt("Año: ");
        double precio = Esdia.readDouble("Precio: ");
        return new Libro(isbn, titulo, autor, anio, precio);
    }

    public int elegirLibro(List<Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println("(No hay libros)");
            return -1;
        }
        for (int i = 0; i < libros.size(); i++) {
            System.out.println((i + 1) + ") " + libros.get(i).toString());
        }
        return Esdia.readInt("Elige numero de libro (0 para cancelar): ") - 1;
    }

    public void modificarLibro(Libro l) {
        System.out.println("Deja en blanco o pulsa Enter para no cambiar un campo.");
        String titulo = Esdia.readString("Nuevo titulo (" + l.getTitulo() + "): ");
        String autor  = Esdia.readString("Nuevo autor (" + l.getAutor() + "): ");
        String anioS  = Esdia.readString("Nuevo año (" + l.getAnio() + "): ");
        String precS  = Esdia.readString("Nuevo precio (" + l.getPrecio() + "): ");

        if (!titulo.trim().isEmpty()) l.setTitulo(titulo.trim());
        if (!autor.trim().isEmpty())  l.setAutor(autor.trim());
        if (!anioS.trim().isEmpty()) {
            try { l.setAnio(Integer.parseInt(anioS.trim())); } catch (Exception e) {}
        }
        if (!precS.trim().isEmpty()) {
            try { l.setPrecio(Double.parseDouble(precS.trim().replace(',', '.'))); } catch (Exception e) {}
        }
    }
}
