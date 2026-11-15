package modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import es.usal.progiii.tools.Rutas;

public class GestorFacturas {

    private List<Factura> facturas;
    private String nombreFichero;

    public GestorFacturas(String nombreFichero) {
        this.nombreFichero = nombreFichero;
        this.facturas = new ArrayList<>();
    }

    public void cargarFacturas() throws IOException {
        facturas.clear();
        // El fichero se busca en el Escritorio
        Path ruta = Rutas.pathToFileOnDesktop(nombreFichero);
        List<String> lineas = Files.readAllLines(ruta);

        for (String linea : lineas) {
            if (linea.trim().isEmpty()) continue;

            String[] partes = linea.split("\t");

            Factura f = new Factura(
                partes[0],
                Double.parseDouble(partes[1]),
                partes[2],
                Double.parseDouble(partes[3]),
                partes[4],
                partes[5],
                partes[6],
                Double.parseDouble(partes[7])
            );
            facturas.add(f);
        }
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public List<Factura> filtrarPorImporteMinimo(double minimo) {
        List<Factura> resultado = new ArrayList<>();
        for (Factura f : facturas) {
            if (f.calcularImporteFinal() > minimo) {
                resultado.add(f);
            }
        }
        return resultado;
    }

    public void exportarHTML(String nombreSalida) throws IOException {
        String tabla = "<table border='1'>\n";
        tabla = tabla + "<tr><th>Concepto</th><th>Descuento</th><th>Fecha</th>"
                      + "<th>Importe</th><th>NIF</th><th>Cliente</th>"
                      + "<th>Direccion</th><th>IVA</th><th>Importe Final</th></tr>\n";

        for (Factura f : facturas) {
            tabla = tabla + "<tr>"
                    + "<td>" + f.getConcepto() + "</td>"
                    + "<td>" + f.getDescuento() + "</td>"
                    + "<td>" + f.getFecha() + "</td>"
                    + "<td>" + f.getImporte() + "</td>"
                    + "<td>" + f.getNif() + "</td>"
                    + "<td>" + f.getNombreCliente() + "</td>"
                    + "<td>" + f.getDireccion() + "</td>"
                    + "<td>" + f.getIva() + "</td>"
                    + "<td>" + f.calcularImporteFinal() + "</td>"
                    + "</tr>\n";
        }
        tabla = tabla + "</table>";

        String plantilla = "<!DOCTYPE html>\n"
                + "<html><head><meta charset='UTF-8'><title>Facturas</title></head>\n"
                + "<body>\n"
                + "<h1>Listado de Facturas</h1>\n"
                + "%%TABLA%%\n"
                + "</body></html>";

        String htmlFinal = plantilla.replace("%%TABLA%%", tabla);

        // Guardamos en el Escritorio
        Path rutaSalida = Rutas.pathToFileOnDesktop(nombreSalida);
        Files.writeString(rutaSalida, htmlFinal);
    }

    public void exportarCSV(String nombreSalida) throws IOException {
        String contenido = "Concepto,Descuento,Fecha,Importe,NIF,Cliente,Direccion,IVA,ImporteFinal\n";

        for (Factura f : facturas) {
            contenido = contenido
                    + f.getConcepto() + ","
                    + f.getDescuento() + ","
                    + f.getFecha() + ","
                    + f.getImporte() + ","
                    + f.getNif() + ","
                    + f.getNombreCliente() + ","
                    + f.getDireccion() + ","
                    + f.getIva() + ","
                    + f.calcularImporteFinal() + "\n";
        }

        Path rutaSalida = Rutas.pathToFileOnDesktop(nombreSalida);
        Files.writeString(rutaSalida, contenido);
    }
}