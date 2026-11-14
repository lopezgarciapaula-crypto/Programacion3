package SEMANA7.Ejercicio1_7;
public class ModeloSuma {
    private int numero1; 
    private int numero2; 
    private int resultado; 
    private boolean hayResultado; 

    public ModeloSuma(){
        this.numero1 = 0; 
        this.numero2 = 0; 
        this.resultado = 0; 
        this.hayResultado = false;
    }

    public void setNumeros(int n1, int n2){
        this.numero1 = n1;
        this.numero2 = n2; 
        this.hayResultado = false;
    }

    public int getNumero1() { return numero1; }
    public int getNumero2() { return numero2; }
    public int getResultado() { return resultado; }
    public boolean isHayResultado() { return hayResultado; }

    public void calcularSuma(){
        this.resultado = this.numero1 + this.numero2;
        this.hayResultado = true; 

    }
    
}
