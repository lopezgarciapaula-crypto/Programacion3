package controlador;

import modelo.AlmacenModel; 
import vista.AlmacenVista;

public class AlmacenControlador {
    private AlmacenModel modelo; 
    private AlmacenVista vista; 

     public AlmacenControlador(AlmacenModel modelo, AlmacenVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    
}
public void leerVentas() {
        int[][] tabla = vista.pedirTablaVentas(modelo.getNumAlmacenes(), modelo.getNumProductos());
        modelo.guardarVentas(tabla);
        vista.mostrarMensaje("Ventas guardadas correctamente.");
    }
public void leerPrecios() {
        int[] precios = vista.pedirPrecios(modelo.getNumProductos());
        modelo.guardarPrecios(precios);
        vista.mostrarMensaje("Precios guardados correctamente.");
    }

    public void calcularIngresos() {
        if (!modelo.hayVentas() || !modelo.hayPrecios()) {
            vista.mostrarError("Debes leer primero ventas (opcion 1) y precios (opcion 2).");
            return;
        }
        vista.mostrarMensaje("Ingresos calculados. Usa la opcion 4 para verlos.");
    }

    public void mostrarResultados() {
        if (!modelo.hayVentas() || !modelo.hayPrecios()) {
            vista.mostrarError("No hay datos suficientes. Lee ventas y precios primero.");
            return;
        }
        int[] ingresos = modelo.calcularIngresosPorAlmacen();
        int total = modelo.calcularIngresosTotales();
        vista.mostrarResultados(ingresos, total);
    }
}
