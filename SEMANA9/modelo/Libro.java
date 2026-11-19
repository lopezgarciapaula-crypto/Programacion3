package modelo;

import java.io.Serializable;

public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;

    private String isbn;
    private String titulo;
    private String autor;
    private int anio;
    private double precio;

    public Libro(String isbn, String titulo, String autor, int anio, double precio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.precio = precio;
    }

    public String getIsbn()   { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor()  { return autor; }
    public int getAnio()      { return anio; }
    public double getPrecio() { return precio; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor)   { this.autor = autor; }
    public void setAnio(int anio)        { this.anio = anio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public static String[] cabecera() {
        return new String[] { "ISBN", "TITULO", "AUTOR", "AÑO", "PRECIO" };
    }

    public String[] aFila() {
        return new String[] {
            isbn,
            titulo,
            autor,
            String.valueOf(anio),
            String.valueOf(precio)
        };
    }

    public String aCsv() {
        return isbn + ";" + titulo + ";" + autor + ";" + anio + ";" + precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro)) return false;
        Libro otro = (Libro) o;
        return isbn != null && isbn.equals(otro.isbn);
    }

    @Override
    public int hashCode() {
        return isbn == null ? 0 : isbn.hashCode();
    }

    @Override
    public String toString() {
        return isbn + " - " + titulo + " (" + autor + ", " + anio + ")";
    }
}