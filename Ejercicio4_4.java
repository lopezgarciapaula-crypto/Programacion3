import java.util.Scanner; 

class Alumno {
    String nombre; 
    double parcial1; 
    double parcial2; 
    double notaFinal; 
}

public class Ejercicio4_4 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Cuántos alumnos hay en el curso"); 
        int numAlumnos = teclado.nextInt();
        teclado.nextLine(); 

        Alumno[] listaAlumnos = new Alumno[numAlumnos]; 

        for(int i=0; i < numAlumnos; i++){
            listaAlumnos[i]= new Alumno();

            System.out.println("\n--- Datos del Alumno" +(i+1)+ "---");

            System.out.print("Nombre: ");
            listaAlumnos[i].nombre = teclado.nextLine();

            System.out.print("Nota Parcial 1: ");
            listaAlumnos[i].parcial1 = teclado.nextDouble();

            System.out.print("Nota Parcial 2: ");
            listaAlumnos[i].parcial2 = teclado.nextDouble();

            System.out.print("Nota Examen Final: ");
            listaAlumnos[i].notaFinal = teclado.nextDouble();
            
            teclado.nextLine();
        }

    System.out.println("\n=========================================================================");
        // Usamos printf para alinear la tabla (%-15s significa texto a la izquierda de 15 letras, %-10.2f es número con 2 decimales)
        System.out.printf("| %-15s | %-10s | %-10s | %-10s | %-10s |\n", "Alumno", "Parcial 1", "Parcial 2", "Final", "Nota Curso");
        System.out.println("=========================================================================");

        double sumaP1 = 0;
        double sumaP2 = 0;
        double sumaFinal = 0;
        double sumaNotaCurso = 0;

        for (int i = 0; i < numAlumnos; i++) {
           
            double notaCurso = (listaAlumnos[i].parcial1 * 0.10) + 
                               (listaAlumnos[i].parcial2 * 0.10) + 
                               (listaAlumnos[i].notaFinal * 0.80);
 
            sumaP1 += listaAlumnos[i].parcial1;
            sumaP2 += listaAlumnos[i].parcial2;
            sumaFinal += listaAlumnos[i].notaFinal;
            sumaNotaCurso += notaCurso;

            System.out.printf("| %-15s | %-10.2f | %-10.2f | %-10.2f | %-10.2f |\n", 
                listaAlumnos[i].nombre, 
                listaAlumnos[i].parcial1, 
                listaAlumnos[i].parcial2, 
                listaAlumnos[i].notaFinal, 
                notaCurso);
        }
        System.out.println("=========================================================================");

        double mediaP1 = sumaP1 / numAlumnos;
        double mediaP2 = sumaP2 / numAlumnos;
        double mediaFinal = sumaFinal / numAlumnos;
        double mediaCurso = sumaNotaCurso / numAlumnos;

        System.out.println("\n--- MEDIAS DE LA CLASE ---");
        System.out.printf("Media Parcial 1:  %.2f\n", mediaP1);
        System.out.printf("Media Parcial 2:  %.2f\n", mediaP2);
        System.out.printf("Media Final:      %.2f\n", mediaFinal);
        System.out.printf("Media Nota Curso: %.2f\n", mediaCurso);

        teclado.close(); 
    }
}