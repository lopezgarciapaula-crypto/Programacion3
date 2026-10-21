import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        // Creamos un objeto Scanner para leer desde el teclado
        Scanner sc = new Scanner(System.in);

         // Pedimos el primer número
        System.out.print("Introduce el primer número: ");
        double num1 = sc.nextDouble();

         // Pedimos el segundo número
        System.out.print("Introduce el segundo número: ");
        double num2 = sc.nextDouble();

          // Calculamos la suma
        double suma = num1 + num2;

         // Mostramos el resultado
        System.out.println("La suma es: " + suma);

        // Cerramos el Scanner
        sc.close();
    }
}