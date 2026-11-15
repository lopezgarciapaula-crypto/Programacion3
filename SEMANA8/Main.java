package SEMANA8;

import SEMANA8.modelo.QuinielaModel;
import SEMANA8.vista.QuinielaVista;
import SEMANA8.controlador.QuinielaControlador;

public class Main {
    public static void main(String[] args) {
        QuinielaModel modelo = new QuinielaModel();
        
        // ESTA ES LA NUEVA LINEA DE LA V2  
        modelo.cargarPartidosDesdeFichero(); 

        QuinielaVista vista = new QuinielaVista();
        QuinielaControlador controlador = new QuinielaControlador(modelo, vista);

        vista.mostrarMenu();
    }
}