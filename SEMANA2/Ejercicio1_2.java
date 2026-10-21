import java.util.Scanner; 

public class Ejercicio1_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce tu ano de nacimiento: ");
        int anioNacimiento = sc.nextInt();

        System.out.print("Introduce el ano actual: ");
        int anioActual = sc.nextInt();

         int edad = anioActual - anioNacimiento;

         // Usando println (concatenación)
        System.out.println("Tienes " + edad + " anos.");

        // Usando printf (formato tipo C)
        System.out.printf("Tienes %d anos.%n", edad);

        sc.close();
    }
}