import java.util.Scanner; 

public class Ejercicio3_4{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        final double IVA = 0.04;

        Producto[] productos = new Producto[2]; 
        productos[0] = new Producto("Peras", 0); 
        productos[1] = new Producto("Manzanas", 0);

        System.out.println("--- INICIO DE JORNADA ---");
        System.out.print("Precio del kg de peras (sin IVA): ");
        double precioPeras = sc.nextDouble();
        productos[0].setPrecioKg(precioPeras);

        System.out.print("Precio del kg de manzanas (sin IVA): ");
        double precioManzanas = sc.nextDouble();
        productos[1].setPrecioKg(precioManzanas);
        System.out.println();

        int numCliente = 1; // Contador de clientes
        boolean salir = false;

         while (!salir) {
            System.out.println("--- CLIENTE " + numCliente + " ---");
            
            // Pedimos los kg de cada fruta
            System.out.print("Kg de peras (0 para no comprar): ");
            double kgPeras = sc.nextDouble();
            
            System.out.print("Kg de manzanas (0 para no comprar): ");
            double kgManzanas = sc.nextDouble();

            if (kgPeras == 0 && kgManzanas == 0) {
                salir = true;
                System.out.println("Saliendo del programa... ¡Hasta mañana!");
            } else {
                 double precioPerasConIVA = productos[0].getPrecioKg() * (1 + IVA);
                double precioManzanasConIVA = productos[1].getPrecioKg() * (1 + IVA);
                
                double totalPeras = kgPeras * precioPerasConIVA;
                double totalManzanas = kgManzanas * precioManzanasConIVA;
                
                double totalFactura = totalPeras + totalManzanas;

                System.out.println("---------------------------------------------------------");
                System.out.println(String.format("| Cliente %d |", numCliente));
                System.out.println("---------------------------------------------------------");
 
                 // Si ha comprado peras, lo mostramos
                if (kgPeras > 0) {
                    System.out.printf("| %-10s | %2.0f kg | precio Kg con IVA %5.2f | %6.2f EUR |\n", 
                        productos[0].getNombre(), kgPeras, precioPerasConIVA, totalPeras);
                }
                
                // Si ha comprado manzanas, lo mostramos
                if (kgManzanas > 0) {
                    System.out.printf("| %-10s | %2.0f kg | precio Kg con IVA %5.2f | %6.2f EUR |\n", 
                        productos[1].getNombre(), kgManzanas, precioManzanasConIVA, totalManzanas);
                }
                
                System.out.println("---------------------------------------------------------");
                // Mostramos el total de la factura
                System.out.printf("| Total con IVA %6.2f EUR                               |\n", totalFactura);
                System.out.println("---------------------------------------------------------\n");

                // Pasamos al siguiente cliente
                numCliente = numCliente + 1;
            }
        }
        
        sc.close();
    }
}
