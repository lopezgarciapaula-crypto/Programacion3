package SEMANA8.modelo;

import java.util.ArrayList;

public class Quiniela {
    private ArrayList<Partido> partidos;

    public Quiniela() {
        this.partidos = new ArrayList<>();
    }

    public void agregarPartido(Partido p) { partidos.add(p); }

    public ArrayList<Partido> getPartidos() { return partidos; }
}
