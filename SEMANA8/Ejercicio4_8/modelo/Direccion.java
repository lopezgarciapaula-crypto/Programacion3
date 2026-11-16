package modelo;

import java.util.Random;

public class Direccion {

    private String calle;
    private int numero;
    private int piso;
    private String letra;

    public Direccion(String calle, int numero, int piso, String letra) {
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.letra = letra;
    }

    // Factory method: crea una direccion con valores aleatorios razonables
    public static Direccion crearAleatoria() {
        Random r = new Random();
        String[] calles = { "Mayor", "Real", "Sol", "Luna", "Gran Via",
                            "Cervantes", "Goya", "Alcala", "Serrano", "Colon" };
        String[] letras = { "A", "B", "C", "D" };

        String calle = calles[r.nextInt(calles.length)];
        int numero   = r.nextInt(100) + 1;   // 1..100
        int piso     = r.nextInt(6);         // 0..5
        String letra = letras[r.nextInt(letras.length)];

        return new Direccion(calle, numero, piso, letra);
    }

    public static String[] cabecera() {
        return new String[] { "CALLE", "NUM", "PISO", "LETRA" };
    }

    public String[] aFila() {
        return new String[] {
            calle,
            String.valueOf(numero),
            String.valueOf(piso),
            letra
        };
    }

    public String aCsv() {
        return calle + ";" + numero + ";" + piso + ";" + letra;
    }

    public String getCalle()  { return calle; }
    public int getNumero()    { return numero; }
    public int getPiso()      { return piso; }
    public String getLetra()  { return letra; }
}