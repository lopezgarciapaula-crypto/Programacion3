package SEMANA7.Ejercicio1_7;

public class Main {
    public static void main(String[] args) {
        // 1. Crear las instancias
        ModeloSuma modelo = new ModeloSuma();
        VistaSuma vista = new VistaSuma();
        
        // 2. Inyectar dependencias
        ControladorSuma controlador = new ControladorSuma(modelo, vista);
        vista.setControlador(controlador);

        // 3. Arrancar la aplicación
        vista.iniciarBuclePrincipal();
    }
}
