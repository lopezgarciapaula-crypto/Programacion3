import java.util.Scanner; 

public class Ejercicio1_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce tu año de nacimiento: ");
        int anioNacimiento = sc.nextInt();

        System.out.print("Introduce el año actual: ");
        int anioActual = sc.nextInt();

         int edad = anioActual - anioNacimiento;

         // Usando println (concatenación)
        System.out.println("Tienes " + edad + " años.");

        // Usando printf (formato tipo C)
        System.out.printf("Tienes %d años.%n", edad);

        sc.close();
    }
}