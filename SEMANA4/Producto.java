public class Producto {

    private String nombre; 
    private double precioKg; 

    public Producto(String nombre, double precioKg){
        this.nombre = nombre; 
        this.precioKg = precioKg; 
    }

    public String getNombre(){
        return nombre;
    }
    
    public double getPrecioKg(){
        return precioKg; 
    }
    
    public void setPrecioKg(double precioKg){
        this.precioKg = precioKg;
    }
}
