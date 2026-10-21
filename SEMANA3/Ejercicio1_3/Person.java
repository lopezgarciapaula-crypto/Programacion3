import java.util.Scanner;  // Importamos la herramienta para leer del teclado

public class Person {

    // ===== ATRIBUTOS =====
    // Son las "características" de cada persona
    private String nombre;
    private double altura;  // en metros
    private double peso;    // en kilogramos

    // ===== GETTERS Y SETTERS =====

    // Getter de nombre: devuelve el nombre
    public String getNombre() {
        return nombre;
    }

    // Setter de nombre: cambia el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;   // "this.nombre" = el atributo del objeto
                                // "nombre" = el parámetro que me pasan
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    // ===== MÉTODO MAIN =====
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);  // "sc" es el lector de teclado

        // Creamos 3 objetos Person (3 personas vacías)
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();

        // ---- Pedimos datos para la persona 1 ----
        System.out.println("--- Datos de la persona 1 ---");

        System.out.print("Nombre: ");
        p1.setNombre(sc.nextLine());   // Leemos texto y lo guardamos con el setter

        System.out.print("Altura (m): ");
        p1.setAltura(sc.nextDouble());

        System.out.print("Peso (kg): ");
        p1.setPeso(sc.nextDouble());
        sc.nextLine(); // limpia el Enter pendiente

        // ---- Pedimos datos para la persona 2 ----
        System.out.println("--- Datos de la persona 2 ---");

        System.out.print("Nombre: ");
        p2.setNombre(sc.nextLine());

        System.out.print("Altura (m): ");
        p2.setAltura(sc.nextDouble());

        System.out.print("Peso (kg): ");
        p2.setPeso(sc.nextDouble());
        sc.nextLine();

        // ---- Pedimos datos para la persona 3 ----
        System.out.println("--- Datos de la persona 3 ---");

        System.out.print("Nombre: ");
        p3.setNombre(sc.nextLine());

        System.out.print("Altura (m): ");
        p3.setAltura(sc.nextDouble());

        System.out.print("Peso (kg): ");
        p3.setPeso(sc.nextDouble());
        sc.nextLine();

        // ---- Comparamos alturas ----
        Person masAlto = p1;  // Suponemos que p1 es el más alto de momento

        if (p2.getAltura() > masAlto.getAltura()) {
            masAlto = p2;
        }
        if (p3.getAltura() > masAlto.getAltura()) {
            masAlto = p3;
        }

        // ---- Comparamos pesos ----
        Person masPesado = p1;

        if (p2.getPeso() > masPesado.getPeso()) {
            masPesado = p2;
        }
        if (p3.getPeso() > masPesado.getPeso()) {
            masPesado = p3;
        }

        // ---- Mostramos resultados ----
        System.out.println("\n=== RESULTADOS ===");
        System.out.println("El más alto es: " + masAlto.getNombre()
                           + " (" + masAlto.getAltura() + " m)");
        System.out.println("El que más pesa es: " + masPesado.getNombre()
                           + " (" + masPesado.getPeso() + " kg)");

        sc.close();  // Cerramos el lector
    }
}
