package Ejercicio1_6;
import java.util.Scanner;

public class ConcesionarioArrays {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in); 
// Array de Coches y Contador
Coche[] listaCoches = new Coche[10]; 
int contador = 0;
int opcion = 0; 

 while (opcion != 5) {
            System.out.println("\n---CONCESIONARIO (ARRAYS)---");
            System.out.println("1. Anadir coche");
            System.out.println("2. Mostrar coches");
            System.out.println("3. Modificar coche");
            System.out.println("4. Borrar coche");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion ==1){
                 if (contador < listaCoches.length) {
                    System.out.print("Matricula: ");
                    String matricula = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    sc.nextLine();

                    listaCoches[contador] = new Coche(matricula, marca, modelo, precio);
                    contador++;
                    System.out.println("Coche anadido con exito");
                } else {
                    System.out.println("El concesionario esta lleno (maximo 10 coches).");
                }

            } else if (opcion == 2) {
                
                if (contador == 0) {
                    System.out.println("No hay coches en el concesionario.");
                } else {
                    
                    for (int i = 0; i < contador; i++) {
                        System.out.println((i + 1) + ". " + listaCoches[i].matricula + " - "
                                + listaCoches[i].marca + " " + listaCoches[i].modelo + " - "
                                + listaCoches[i].precio + "EUR");
                    }
                }

            } else if (opcion == 3) {
                
                System.out.print("Dime la matricula del coche a modificar: ");
                String matricula = sc.nextLine();
                boolean encontrado = false;

                for (int i = 0; i < contador; i++) {
                    if (listaCoches[i].matricula.equalsIgnoreCase(matricula)) {
                        System.out.print("Nueva marca: ");
                        listaCoches[i].marca = sc.nextLine();
                        System.out.print("Nuevo modelo: ");
                        listaCoches[i].modelo = sc.nextLine();
                        System.out.print("Nuevo precio: ");
                        listaCoches[i].precio = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Coche modificado");
                        encontrado = true;
                        break; 
                    }
                }
                if (!encontrado) {
                    System.out.println("No existe ningun coche con esa matricula");
                }

            } else if (opcion == 4) {
                
                System.out.print("Dime la matricula del coche que quieres borrar: ");
                String matricula = sc.nextLine();
                boolean encontrado = false;

                for (int i = 0; i < contador; i++) {
                    if (listaCoches[i].matricula.equalsIgnoreCase(matricula)) {
                        
                        listaCoches[i] = null;
                        System.out.println("Coche borrado (hueco liberado)");
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("No existe ningun coche con esa matricula");
                }

            } else if (opcion == 5) {
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opcion incorrecta, elige 1, 2, 3, 4 o 5");
            }
        }

        sc.close();
            }
    }
    

