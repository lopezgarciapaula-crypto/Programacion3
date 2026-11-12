public class Animal{

    private Cuidador cuidador; 
    private String nombre; 
    private String especie; 
    private double peso; 
    private double consumo; 

    public Animal(Cuidador cuidador, String nombre, String especie, double peso, double consumo){
        this.cuidador=cuidador;
        this.nombre=nombre; 
        this.especie=especie; 
        this.peso=peso; 
        this.consumo=consumo; 
    }
    public Cuidador getCuidador(){
        return cuidador;
    }

    public String getNombre(){
        return nombre;
    }

    public String getEspecie(){
        return especie;
    }

    public double getPeso() {
        return peso;
    }

    public double getConsumo() {
        return consumo;
    }

    public double getCosteDiario(double precioAlimento) {
        return consumo * precioAlimento;
    }
        public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }
}

