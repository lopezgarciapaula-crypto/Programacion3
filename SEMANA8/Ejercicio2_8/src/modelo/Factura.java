package modelo;

public class Factura {

    // Atributos (uno por cada columna del TSV)
    private String concepto;
    private double descuento;
    private String fecha;
    private double importe;
    private String nif;
    private String nombreCliente;
    private String direccion;
    private double iva;

    // Constructor
    public Factura(String concepto, double descuento, String fecha, double importe,
                   String nif, String nombreCliente, String direccion, double iva) {
        this.concepto = concepto;
        this.descuento = descuento;
        this.fecha = fecha;
        this.importe = importe;
        this.nif = nif;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.iva = iva;
    }

    // Cálculo pedido por el enunciado
    public double calcularImporteFinal() {
        return importe * (1 - descuento) * (1 + iva);
    }

    // Getters (para que las otras clases puedan leer los datos)
    public String getConcepto()      { return concepto; }
    public double getDescuento()     { return descuento; }
    public String getFecha()         { return fecha; }
    public double getImporte()       { return importe; }
    public String getNif()           { return nif; }
    public String getNombreCliente() { return nombreCliente; }
    public String getDireccion()     { return direccion; }
    public double getIva()           { return iva; }
}
