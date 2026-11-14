package modelo;

import java.util.ArrayList;

public class AlmacenModel {
    private static final int NUM_ALMACENES = 5;
    private static final int NUM_PRODUCTOS = 2;
    
    private ArrayList<VentasAlmacen> ventas;
    private int[] precios;
    private boolean ventasCargadas;
    private boolean preciosCargados;

    public AlmacenModel() {
        this.ventas = new ArrayList<>();
        this.precios = new int[NUM_PRODUCTOS];
        this.ventasCargadas = false;
        this.preciosCargados = false;
}

 public void guardarVentas(int[][] tablaVentas) {
        ventas.clear();
        for (int i = 0; i < NUM_ALMACENES; i++) {
            ventas.add(new VentasAlmacen(tablaVentas[i]));
        }
        ventasCargadas = true;
    }

public void guardarPrecios(int[] precios) {
        this.precios = precios;
        this.preciosCargados = true;
    }

    public boolean hayVentas() {
        return ventasCargadas;
    }

    public boolean hayPrecios() {
        return preciosCargados;
    }

    public int getNumAlmacenes() {
        return NUM_ALMACENES;
    }

    public int getNumProductos() {
        return NUM_PRODUCTOS;
    }

    public int[] calcularIngresosPorAlmacen() {
        int[] resultado = new int[ventas.size()];
        for (int i = 0; i < ventas.size(); i++) {
            int[] unidades = ventas.get(i).getUnidades();
            int ingreso = 0;
            for (int p = 0; p < NUM_PRODUCTOS; p++) {
                ingreso += unidades[p] * precios[p];
            }
            resultado[i] = ingreso;
        }
        return resultado;
    }

    public int calcularIngresosTotales() {
        int total = 0;
        int[] ingresos = calcularIngresosPorAlmacen();
        for (int i = 0; i < ingresos.length; i++) {
            total += ingresos[i];
        }
        return total;
    }
}