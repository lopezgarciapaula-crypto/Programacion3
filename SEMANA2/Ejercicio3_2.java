import es.usal.progiii.tools.Esdia; 

public class Ejercicio3_2 {
    public static void main (String[] args) {

        int n = 0; 

       // Primer Bucle: Pedir N hasta que sea mayor que cero
        while (n <= 0) {
            n = Esdia.readInt("Introduce un numero entero N mayor que 0: "); // Usamos Esdia

            if (n <= 0) {
                System.err.println("ERROR: El numero debe ser mayor que cero. Intentalo de nuevo.");
            }
        }

        // Segundo Bucle: Pedir N numeros decimales y sumarlos
        float suma = 0;

        for (int i = 1; i <= n; i++) {
            float numero = Esdia.readFloat("Introduce el numero " + i + ": "); // Usamos Esdia
            suma = suma + numero;
        }

        // Calculo la media
        float media = suma / n;

        // Muestro el resultado con printf
        System.out.printf("La media aritmetica de los %d numeros es: %.2f\n", n, media);
    }
}