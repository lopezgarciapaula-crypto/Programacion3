package SEMANA8;

import SEMANA8.modelo.QuinielaModel;
import SEMANA8.vista.QuinielaVista;
import SEMANA8.controlador.QuinielaControlador;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciamos el modelo
        QuinielaModel modelo = new QuinielaModel();
        
        // 2. Cargamos los partidos del fichero (ESTA ES LA MAGIA DE LA V2)
        modelo.cargarPartidosDesdeFichero(); 

        // 3. Instanciamos la vista y el controlador
        QuinielaVista vista = new QuinielaVista();
        QuinielaControlador controlador = new QuinielaControlador(modelo, vista);

        // 4. Arrancamos el menu
        vista.mostrarMenu();
    }
}