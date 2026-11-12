import java.util.HashMap;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        
        HashMap<String, Libro> biblioteca = new HashMap<>();
        
        int opcion = 0;

        do {
            System.out.println("\n--- BIBLIOTECA ---");
            System.out.println("1. Anadir libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Modificar libro");
            System.out.println("4. Borrar libro");
            System.out.println("5. Salir");
            System.out.print("Elige opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    // --- CREAR ---
                    System.out.print("ISBN: ");
                    String isbn = teclado.nextLine();
                    
                    if (biblioteca.containsKey(isbn)) {
                        System.out.println("Error: Ya existe un libro con ese ISBN.");
                    } else {
                        System.out.print("Titulo: ");
                        String titulo = teclado.nextLine();
                        System.out.print("Autor: ");
                        String autor = teclado.nextLine();
                        System.out.print("Precio: ");
                        double precio = teclado.nextDouble();
                        teclado.nextLine();

                        // Guardamos en el HashMap usando el ISBN como clave
                        biblioteca.put(isbn, new Libro(isbn, titulo, autor, precio));
                        System.out.println("Libro añadido con exito.");
                    }
                    break;

                case 2:
                    // --- LEER (Mostrar) ---
                    if (biblioteca.isEmpty()) {
                        System.out.println("La biblioteca esta vacia.");
                    } else {
                        System.out.println("--- LIBROS EN LA BIBLIOTECA ---");
                        // Recorremos los valores del HashMap (los libros)
                        for (Libro l : biblioteca.values()) {
                            System.out.println("ISBN: " + l.getIsbn() + " | Titulo: " + l.getTitulo() + 
                                               " | Autor: " + l.getAutor() + " | Precio: " + l.getPrecio() + "€");
                        }
                    }
                    break;

                case 3:
                    // --- ACTUALIZAR (Modificar) ---
                    System.out.print("Dime el ISBN del libro a modificar: ");
                    String isbnMod = teclado.nextLine();
                    
                    // Buscamos el libro en el HashMap
                    Libro libroEncontrado = biblioteca.get(isbnMod);
                    
                    if (libroEncontrado != null) {
                        System.out.print("Nuevo titulo: ");
                        libroEncontrado.setTitulo(teclado.nextLine());
                        System.out.print("Nuevo autor: ");
                        libroEncontrado.setAutor(teclado.nextLine());
                        System.out.print("Nuevo precio: ");
                        libroEncontrado.setPrecio(teclado.nextDouble());
                        teclado.nextLine();
                        System.out.println("Libro modificado.");
                    } else {
                        System.out.println("No existe ningun libro con ese ISBN.");
                    }
                    break;

                case 4:
                    // --- BORRAR ---
                    System.out.print("Dime el ISBN del libro a borrar: ");
                    String isbnBorrar = teclado.nextLine();
                    
                    if (biblioteca.containsKey(isbnBorrar)) {
                        biblioteca.remove(isbnBorrar);
                        System.out.println("Libro borrado.");
                    } else {
                        System.out.println("No existe ningun libro con ese ISBN.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 5);

        teclado.close();
    }
}
