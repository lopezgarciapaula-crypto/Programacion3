package SEMANA8.controlador;

import SEMANA8.modelo.Partido;
import SEMANA8.modelo.QuinielaModel;
import SEMANA8.vista.QuinielaVista;
import java.util.ArrayList;

public class QuinielaControlador {
    private QuinielaModel modelo;
    private QuinielaVista vista;

    public QuinielaControlador(QuinielaModel modelo, QuinielaVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void agregarPartido(String local, String visitante) {
        modelo.agregarPartido(local, visitante);
    }

    public boolean registrarResultado(int indice, String resultado) {
        return modelo.registrarResultado(indice, resultado);
    }

    public ArrayList<Partido> obtenerPartidos() {
        return modelo.getQuiniela().getPartidos();
    }
}