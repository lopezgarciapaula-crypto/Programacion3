package vista;

import controlador.ControladorFacturas;
import modelo.Factura;
import java.util.List;
import es.usal.progiii.tools.Esdia;
import es.usal.progiii.tools.OpMat;

public class VistaFacturas {

    private ControladorFacturas controlador;

    public void setControlador(ControladorFacturas controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenuPrincipal() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n=== MENU FACTURAS ===");
            System.out.println("1. Filtrar por importe mínimo");
            System.out.println("2. Mostrar todas las facturas");
            System.out.println("3. Exportar a HTML");
            System.out.println("4. Exportar a CSV");
            System.out.println("0. Salir");

            opcion = Esdia.readInt("Opción: ");

            if (opcion == 1) {
                opcionFiltrar();
            } else if (opcion == 2) {
                opcionMostrarTodas();
            } else if (opcion == 3) {
                opcionExportarHTML();
            } else if (opcion == 4) {
                opcionExportarCSV();
            } else if (opcion == 0) {
                System.out.println("Adiós.");
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    private void opcionFiltrar() {
        double minimo = Esdia.readDouble("Importe mínimo: ");
        List<Factura> lista = controlador.obtenerFacturasFiltradas(minimo);
        mostrarTabla(lista, "FACTURAS CON IMPORTE FINAL > " + minimo);
    }

    private void opcionMostrarTodas() {
        mostrarTabla(controlador.obtenerTodasLasFacturas(), "TODAS LAS FACTURAS");
    }

    private void opcionExportarHTML() {
        String ruta = Esdia.readString("Nombre del fichero HTML (ej: facturas.html): ");
        try {
            controlador.exportarHTML(ruta);
            System.out.println("HTML generado en el Escritorio: " + ruta);
        } catch (Exception e) {
            System.out.println("Error al exportar: " + e.getMessage());
        }
    }

    private void opcionExportarCSV() {
        String ruta = Esdia.readString("Nombre del fichero CSV (ej: facturas.csv): ");
        try {
            controlador.exportarCSV(ruta);
            System.out.println("CSV generado en el Escritorio: " + ruta);
        } catch (Exception e) {
            System.out.println("Error al exportar: " + e.getMessage());
        }
    }

    private void mostrarTabla(List<Factura> lista, String titulo) {
        System.out.println("\n--- " + titulo + " ---");

        if (lista.isEmpty()) {
            System.out.println("(Sin resultados)");
            return;
        }

        String[][] datos = new String[lista.size() + 1][9];

        datos[0][0] = "Concepto";
        datos[0][1] = "Descuento";
        datos[0][2] = "Fecha";
        datos[0][3] = "Importe";
        datos[0][4] = "NIF";
        datos[0][5] = "Cliente";
        datos[0][6] = "Direccion";
        datos[0][7] = "IVA";
        datos[0][8] = "Importe Final";

        for (int i = 0; i < lista.size(); i++) {
            Factura f = lista.get(i);
            datos[i + 1][0] = f.getConcepto();
            datos[i + 1][1] = String.valueOf(f.getDescuento());
            datos[i + 1][2] = f.getFecha();
            datos[i + 1][3] = String.valueOf(f.getImporte());
            datos[i + 1][4] = f.getNif();
            datos[i + 1][5] = f.getNombreCliente();
            datos[i + 1][6] = f.getDireccion();
            datos[i + 1][7] = String.valueOf(f.getIva());
            datos[i + 1][8] = String.valueOf(f.calcularImporteFinal());
        }

        OpMat.printToScreen(datos);
    }
}