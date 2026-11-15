package SEMANA8.modelo;

public class Partido {
    private Equipo local;
    private Equipo visitante;
    private String resultado; // "1", "X", "2" o null si no jugado

    public Partido(Equipo local, Equipo visitante) {
        this.local = local;
        this.visitante = visitante;
        this.resultado = null;
    }

    public Equipo getLocal() { return local; }
    public Equipo getVisitante() { return visitante; }
    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }

    @Override
    public String toString() {
        String res = (resultado == null) ? "-" : resultado;
        return local.getNombre() + " - " + visitante.getNombre() + " [" + res + "]";
    }
}