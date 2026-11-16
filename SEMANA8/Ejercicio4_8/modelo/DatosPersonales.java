package modelo;

import java.util.Random;

public class DatosPersonales {

    private String nombre;
    private String apellidos;
    private int edad;
    private String nif;

    public DatosPersonales(String nombre, String apellidos, int edad, String nif) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.nif = nif;
    }

    public static DatosPersonales crearAleatorio() {
        Random r = new Random();
        String[] nombres = { "Juan", "Maria", "Carlos", "Ana", "Luis",
                             "Lucia", "Pedro", "Elena", "Javier", "Sara" };
        String[] apellidos = { "Perez", "Lopez", "Garcia", "Martinez", "Fernandez",
                               "Sanchez", "Romero", "Torres", "Navarro", "Gil" };

        String nombre   = nombres[r.nextInt(nombres.length)];
        String apellido = apellidos[r.nextInt(apellidos.length)] + " " +
                          apellidos[r.nextInt(apellidos.length)];
        int edad        = r.nextInt(43) + 18;   // 18..60
        String nif      = generarNif(r);

        return new DatosPersonales(nombre, apellido, edad, nif);
    }

    private static String generarNif(Random r) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String num = String.format("%08d", r.nextInt(100_000_000));
        char letra = letras.charAt(r.nextInt(letras.length()));
        return num + letra;
    }

    public static String[] cabecera() {
        return new String[] { "NOMBRE", "APELLIDOS", "EDAD", "NIF" };
    }

    public String[] aFila() {
        return new String[] {
            nombre,
            apellidos,
            String.valueOf(edad),
            nif
        };
    }

    public String aCsv() {
        return nombre + ";" + apellidos + ";" + edad + ";" + nif;
    }

    public String getNombre()  { return nombre; }
    public String getNif()     { return nif; }
}