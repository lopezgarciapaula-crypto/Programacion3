import java.util.ArrayList;

public class Refugio {

    // CAMBIO 1: Usamos ArrayList en vez de un Array fijo
    private ArrayList<Animal> animales; 
    private double precioAlimento;

    public Refugio(){
        // CAMBIO 2: Inicializamos la lista vacía
        this.animales = new ArrayList<>();
        this.precioAlimento = 3.0;
    }

    // Ya no necesitamos "crearRegistro" con capacidad, la lista crece sola
    public boolean hayRegistro(){
        return animales != null; // Siempre será true, pero lo dejamos por compatibilidad
    }

    // Ya no hay límite, la lista crece sola
    public boolean estaLleno(){
        return false; 
    }

    // --- CREATE (Añadir) ---
    public void anyadirAnimal(Animal animal) {
        animales.add(animal); // Añadimos al final de la lista
    }
    
    // --- READ (Obtener lista) ---
    public ArrayList<Animal> getAnimales() {
        return animales;
    }

    public int getNumAnimales() {
        return animales.size(); // .size() en vez de un contador manual
    }

    // --- UPDATE (Modificar) ---
    // Buscamos por nombre (o por índice, pero por nombre es más fácil para el usuario)
    public Animal buscarAnimalPorNombre(String nombre) {
        for (Animal a : animales) {
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                return a;
            }
        }
        return null; // Si no lo encuentra
    }

    // --- DELETE (Borrar) ---
    public boolean borrarAnimal(String nombre) {
        Animal a = buscarAnimalPorNombre(nombre);
        if (a != null) {
            animales.remove(a);
            return true;
        }
        return false;
    }

    // --- Cálculos (Los tuyos adaptados a ArrayList) ---
    public double getPrecioAlimento() {
        return precioAlimento;
    }

    public void setPrecioAlimento(double precioAlimento) {
        this.precioAlimento = precioAlimento;
    }

    public double calcularCosteTotal() {
        double total = 0;
        for (Animal a : animales) { // Bucle for-each más limpio
            total = total + a.getCosteDiario(precioAlimento);
        }
        return total;
    }

    public double calcularPesoMedio() {
        if (animales.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (Animal a : animales) {
            suma = suma + a.getPeso();
        }
        return suma / animales.size();
    }
}
