package Ejercicio1_6;
import java.util.ArrayList;
import java.util.Scanner; 

public class Concesionario {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 

        ArrayList<Coche> listaCoches = new ArrayList<>(); 

        int opcion = 0; 

        while(opcion != 5){
            System.out.println("\n---CONCESIONARIO---"); 
            System.out.println("1. Anadir coche"); 
            System.out.println("2. Mostrar coche"); 
            System.out.println("3. Modificar coche"); 
            System.out.println("4. Borrar coche"); 
            System.out.println("5. Salir"); 
            System.out.print("Elige una opcion: "); 

            opcion = sc.nextInt(); 
            sc.nextLine(); 

            if(opcion == 1){
                // ---- AÑADIR ----
                System.out.print("Matricula: "); 
                String matricula = sc.nextLine(); 

                // Comprobar si ya existe
                boolean existe = false;
                for (int i = 0; i < listaCoches.size(); i++) {
                    if (listaCoches.get(i).matricula.equalsIgnoreCase(matricula)) {
                        existe = true;
                        break;
                    }
                }

                if (existe) {
                    System.out.println("Ya existe un coche con esa matricula.");
                } else {
                    System.out.print("Marca: "); 
                    String marca = sc.nextLine(); 
                    System.out.print("Modelo: "); 
                    String modelo = sc.nextLine(); 
                    System.out.print("Precio: "); 
                    double precio = sc.nextDouble(); 
                    sc.nextLine(); 

                    listaCoches.add(new Coche(matricula, marca, modelo, precio)); 
                    System.out.println("Coche anadido con exito"); 
                }

            } else if (opcion == 2){
                // ---- MOSTRAR ----
                if(listaCoches.isEmpty()){
                    System.out.println("No hay coches en el concesionario."); 
                } else {
                    for(int i = 0; i < listaCoches.size(); i++){
                        Coche c = listaCoches.get(i); 
                        System.out.println((i+1) + ". " + c.matricula + " - " 
                            + c.marca + " " + c.modelo + " - " + c.precio + "EUR");
                    }
                }

            } else if (opcion == 3) {
                // ---- MODIFICAR ----
                System.out.print("Dime la matricula del coche a modificar: "); 
                String matricula = sc.nextLine(); 

                Coche encontrado = null;
                for(int i = 0; i < listaCoches.size(); i++){
                    if(listaCoches.get(i).matricula.equalsIgnoreCase(matricula)){
                        encontrado = listaCoches.get(i);
                        break;
                    }
                }

                if(encontrado != null){
                    System.out.print("Nueva marca: "); 
                    encontrado.marca = sc.nextLine(); 
                    System.out.print("Nuevo modelo: "); 
                    encontrado.modelo = sc.nextLine(); 
                    System.out.print("Nuevo precio: "); 
                    encontrado.precio = sc.nextDouble(); 
                    sc.nextLine(); 

                    System.out.println("Coche modificado"); 
                } else {
                    System.out.println("No existe ningun coche con esa matricula");
                }

            } else if (opcion == 4){
                // ---- BORRAR ----
                System.out.print("Dime la matricula del coche que quieres borrar: "); 
                String matricula = sc.nextLine();

                Coche encontrado = null;
                for(int i = 0; i < listaCoches.size(); i++){
                    if(listaCoches.get(i).matricula.equalsIgnoreCase(matricula)){
                        encontrado = listaCoches.get(i);
                        break;
                    }
                }

                if(encontrado != null){
                    listaCoches.remove(encontrado); 
                    System.out.println("Coche borrado"); 
                } else {
                    System.out.println("No existe ningun coche con esa matricula"); 
                }

            } else if (opcion == 5){
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opcion incorrecta, elige 1, 2, 3, 4 o 5");
            }
        }
    
        sc.close();
    }
}

