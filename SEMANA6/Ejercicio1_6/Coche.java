package Ejercicio1_6;
public class Coche {

    String matricula;
    String marca; 
    String modelo; 
    double precio;

    public Coche(String matricula, String marca, String modelo, double precio){
        this.matricula = matricula;
        this.marca = marca; 
        this.modelo = modelo; 
        this.precio = precio; 
    }
    public String toString() {
        return matricula + " - " + marca + " - " + modelo + " - " + precio + "€";
    }

}
