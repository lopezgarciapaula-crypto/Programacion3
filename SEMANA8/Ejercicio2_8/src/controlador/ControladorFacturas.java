package controlador;

import modelo.Factura;
import modelo.GestorFacturas;
import java.util.List;

public class ControladorFacturas {

    private GestorFacturas modelo;

    public ControladorFacturas(GestorFacturas modelo) {
        this.modelo = modelo;
    }

    public List<Factura> obtenerTodasLasFacturas() {
        return modelo.getFacturas();
    }

    public List<Factura> obtenerFacturasFiltradas(double minimo) {
        return modelo.filtrarPorImporteMinimo(minimo);
    }

    public void exportarHTML(String ruta) throws Exception {
        modelo.exportarHTML(ruta);
    }

    public void exportarCSV(String ruta) throws Exception {
        modelo.exportarCSV(ruta);
    }
}