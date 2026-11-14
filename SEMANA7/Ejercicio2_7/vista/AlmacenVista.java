package vista;

import controlador.AlmacenControlador; 
import java.util.Scanner; 

public class AlmacenVista {

    private AlmacenControlador controlador; 
    private Scanner sc;

    public AlmacenVista() {
        this.sc = new Scanner(System.in);
    }
    public void setControlador(AlmacenControlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenuPrincipal() {
        String opcion = "";
        while (!opcion.equalsIgnoreCase("q")) {
            System.out.println("\n===== MENU =====");
            System.out.println("1.- Leer tabla de ventas");
            System.out.println("2.- Leer tabla de precios");
            System.out.println("3.- Calcular ingresos totales");
            System.out.println("4.- Mostrar resultados");
            System.out.println("q.- Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    controlador.leerVentas();
                    break;
                case "2":
                    controlador.leerPrecios();
                    break;
                case "3":
                    controlador.calcularIngresos();
                    break;
                case "4":
                    controlador.mostrarResultados();
                    break;
                case "q":
                case "Q":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    public int[][] pedirTablaVentas(int numAlmacenes, int numProductos) {
        int[][] tabla = new int[numAlmacenes][numProductos];
        for (int i = 0; i < numAlmacenes; i++) {
            for (int p = 0; p < numProductos; p++) {
                System.out.print("Almacen " + (i + 1) + " - Producto " + (p + 1) + " (unidades): ");
                tabla[i][p] = Integer.parseInt(sc.nextLine());
            }
        }
        return tabla;
    }

    public int[] pedirPrecios(int numProductos) {
        int[] precios = new int[numProductos];
        for (int p = 0; p < numProductos; p++) {
            System.out.print("Precio producto " + (p + 1) + ": ");
            precios[p] = Integer.parseInt(sc.nextLine());
        }
        return precios;
    }

    public void mostrarError(String mensaje) {
        System.out.println("AVISO: " + mensaje);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarResultados(int[] ingresosPorAlmacen, int total) {
        System.out.println("\n--- INGRESOS POR ALMACEN ---");
        for (int i = 0; i < ingresosPorAlmacen.length; i++) {
            System.out.println("Almacen " + (i + 1) + ": " + ingresosPorAlmacen[i] + " EUR");
        }
        System.out.println("-----------------------------");
        System.out.println("INGRESOS TOTALES: " + total + " EUR");
    }
}
