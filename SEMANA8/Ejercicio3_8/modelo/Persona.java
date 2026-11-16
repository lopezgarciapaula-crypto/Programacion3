package modelo;

public class Persona {

    private String nombre;
    private String telefono;
    private double peso;

    public Persona(String nombre, String telefono, double peso) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.peso = peso;
    }

    // Cabecera de la tabla (fila de títulos)
    public static String[] cabecera() {
        return new String[] { "NOMBRE", "TELEFONO", "PESO" };
    }

    // Estado del objeto como fila de la tabla
    public String[] aFila() {
        return new String[] { nombre, telefono, String.valueOf(peso) };
    }
}
