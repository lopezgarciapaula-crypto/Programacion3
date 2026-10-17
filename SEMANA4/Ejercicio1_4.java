public class Ejercicio1_4 {
    public static void main (String[] args) {

        //Primero comprobamos que haya exactamente dos argumentos
        if(args.length != 2){
            System.err.println("ERROR: Debes introducir exactamente 2 numeros como argumentos.");
            System.err.println("Ejemplo: java Ejercicio1_4 5 10");
            return; // Salimos del programa
        }

        //Segundo, intento convertir los textos de los argumentos a numeros
        try {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

        // Calculo su suma y la muestro
        int suma = num1 + num2; 
        System.out.println("La suma de " + num1 + " + " + num2 + " es: " + suma);

    } catch (NumberFormatException e){
        // Si meto letras o simbolos raros en vez de los numeros saltara este error
    System.err.println("ERROR: Los argumentos deben ser numeros enteros validos.");
        }
    }
}
