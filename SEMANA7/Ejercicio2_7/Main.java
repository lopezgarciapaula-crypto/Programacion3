import controlador.AlmacenControlador; 
import modelo.AlmacenModel; 
import vista.AlmacenVista; 

public class Main {
    public static void main(String[] args) {
        // 1. Crear las instancias (MVC)
        AlmacenModel modelo = new AlmacenModel();
        AlmacenVista vista = new AlmacenVista();
        AlmacenControlador controlador = new AlmacenControlador(modelo, vista);

        // 2. Conectar la vista con el controlador
        vista.setControlador(controlador);

        // 3. Arrancar el menú
        vista.mostrarMenuPrincipal();
    }
    
}
