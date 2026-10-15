public class Person {

    private String nombre = "VALOR_DECLARACION";
    private double altura = 9.99;
    private double peso   = 999.0;

    public Person() {
        System.out.println(">>> Entrando al constructor");
        System.out.println("  Antes: nombre = " + this.nombre);
        System.out.println("  Antes: altura = " + this.altura);
        System.out.println("  Antes: peso   = " + this.peso);

        this.nombre = "VALOR_CONSTRUCTOR";
        this.altura = 1.50;
        this.peso   = 50.0;

        System.out.println("  Despues: nombre = " + this.nombre);
        System.out.println("  Despues: altura = " + this.altura);
        System.out.println("  Despues: peso   = " + this.peso);
        System.out.println(">>> Saliendo del constructor");
    }

    public String getNombre() { return nombre; }
    public double getAltura() { return altura; }
    public double getPeso()   { return peso; }

    public static void main(String[] args) {
        System.out.println(">>> Antes de crear el objeto");

        Person p = new Person();

        System.out.println(">>> Despues de crear el objeto");
        System.out.println("Nombre final: " + p.getNombre());
        System.out.println("Altura final: " + p.getAltura());
        System.out.println("Peso final:   " + p.getPeso());
    }
}