package SEMANA7.Ejercicio1_7;

public class ControladorSuma {
    private ModeloSuma modelo; 
    private VistaSuma vista; 

    public ControladorSuma(ModeloSuma modelo, VistaSuma vista){
        this.modelo = modelo; 
        this.vista = vista;
    }

    public void recibirNumeros(int n1, int n2){
        modelo.setNumeros(n1, n2); 
        vista.mostrarMensaje("Numeros guardados correctamente en el modelo."); 
    }

    public void solicitarCalculoSuma(){
        modelo.calcularSuma();
        vista.mostrarMensaje("Suma calculada. Ya puedes mostrarla.");
    }
    public void solicitarMostrarResultado() {
        if (modelo.isHayResultado()) {
            // El controlador extrae los datos del modelo y los manda a la vista
            int n1 = modelo.getNumero1();
            int n2 = modelo.getNumero2();
            int res = modelo.getResultado();
            vista.mostrarResultado(n1, n2, res);
        } else {
            vista.mostrarMensaje("Error: Primero debes calcular la suma.");
        }
    }
    
}
