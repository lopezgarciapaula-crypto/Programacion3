import controlador.ControladorFacturas;
import modelo.GestorFacturas;
import vista.VistaFacturas;

public class Main {
    public static void main(String[] args) {

        // 1. Crear modelo y cargar facturas
        GestorFacturas modelo = new GestorFacturas("facturas.tsv");
        try {
            modelo.cargarFacturas();
        } catch (Exception e) {
            System.out.println("Error al cargar facturas: " + e.getMessage());
            return;
        }

        // 2. Crear vista
        VistaFacturas vista = new VistaFacturas();

        // 3. Crear controlador (inyectando el modelo por constructor)
        ControladorFacturas controlador = new ControladorFacturas(modelo);

        // 4. Inyectar el controlador en la vista (por setter)
        vista.setControlador(controlador);

        // 5. Arrancar el menú
        vista.mostrarMenuPrincipal();
    }
}