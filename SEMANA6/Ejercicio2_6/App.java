import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Refugio refugio = new Refugio();
        int opcion = 0;

        do {
            System.out.println("\n--- GESTION DEL REFUGIO ---");
            System.out.println("1. Configurar el precio del alimento");
            System.out.println("2. Anadir un nuevo animal");
            System.out.println("3. Mostrar informacion");
            System.out.println("4. Modificar un animal");
            System.out.println("5. Borrar un animal");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion (1-6): ");

            try {
                opcion = teclado.nextInt();
                teclado.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Nuevo precio del alimento: ");
                        double precio = teclado.nextDouble();
                        teclado.nextLine();
                        refugio.setPrecioAlimento(precio);
                        System.out.println("Precio actualizado.");
                        break;

                                        case 2:
                        // --- AÑADIR ANIMAL ---
                        System.out.println("--- Datos del Cuidador ---");
                        System.out.print("Nombre del cuidador: ");
                        String nombreCuidador = teclado.nextLine();
                        System.out.print("Apellidos del cuidador: ");
                        String apellidosCuidador = teclado.nextLine();
                        System.out.print("Tiene formacion? (true/false): ");
                        boolean formacion = teclado.nextBoolean();
                        teclado.nextLine(); // Limpiar buffer
                        
                        // Creamos el cuidador con los 3 datos que pide
                        Cuidador c = new Cuidador(nombreCuidador, apellidosCuidador, formacion); 

                        System.out.println("--- Datos del Animal ---");
                        System.out.print("Nombre del animal: ");
                        String nombre = teclado.nextLine();
                        System.out.print("Especie: ");
                        String especie = teclado.nextLine();
                        System.out.print("Peso: ");
                        double peso = teclado.nextDouble();
                        System.out.print("Consumo diario: ");
                        double consumo = teclado.nextDouble();
                        teclado.nextLine();
                        
                        // Creamos el animal con TODOS los datos
                        Animal nuevo = new Animal(c, nombre, especie, peso, consumo); 
                        refugio.anyadirAnimal(nuevo);
                        System.out.println("Animal anadido.");
                        break;

                    case 3:
                        // --- MOSTRAR ---
                        ArrayList<Animal> lista = refugio.getAnimales();
                        if (lista.isEmpty()) {
                            System.out.println("No hay animales en el refugio.");
                        } else {
                            System.out.println("--- LISTA DE ANIMALES ---");
                            for (Animal a : lista) {
                                System.out.println("- " + a.getNombre() + " (" + a.getEspecie() + ") | Peso: " + a.getPeso() + " | Consumo: " + a.getConsumo());
                            }
                            System.out.println("Coste total de alimento: " + refugio.calcularCosteTotal());
                            System.out.println("Peso medio de los animales: " + refugio.calcularPesoMedio());
                        }
                        break;

                    case 4:
                        // --- MODIFICAR ---
                        System.out.print("Nombre del animal a modificar: ");
                        String nombreMod = teclado.nextLine();
                        Animal encontrado = refugio.buscarAnimalPorNombre(nombreMod);
                        if (encontrado != null) {
                            System.out.print("Nuevo peso (actual " + encontrado.getPeso() + "): ");
                            double nuevoPeso = teclado.nextDouble();
                            teclado.nextLine();
                            encontrado.setPeso(nuevoPeso); 
                            System.out.println("Animal modificado.");
                        } else {
                            System.out.println("No existe ese animal.");
                        }
                        break;

                    case 5:
                        // --- BORRAR ---
                        System.out.print("Nombre del animal a borrar: ");
                        String nombreBorrar = teclado.nextLine();
                        if (refugio.borrarAnimal(nombreBorrar)) {
                            System.out.println("Animal borrado.");
                        } else {
                            System.out.println("No existe ese animal.");
                        }
                        break;

                    case 6:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opcion incorrecta.");
                }

            } catch (Exception e) {
                System.out.println("Error: Introduce un numero valido.");
                teclado.nextLine(); // Limpiar el buffer si hay error
            }

        } while (opcion != 6);

        teclado.close();
    }
}