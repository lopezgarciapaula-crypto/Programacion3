import controlador.PersonasControlador;
import modelo.PersonasModel;
import vista.PersonasVista;

public class Main {
    public static void main(String[] args) {
        PersonasModel modelo = new PersonasModel();
        PersonasVista vista = new PersonasVista();
        PersonasControlador controlador = new PersonasControlador(modelo, vista);

        vista.setControlador(controlador);
        vista.mostrarMenuPrincipal();
    }
}
