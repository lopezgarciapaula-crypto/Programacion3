package modelo;

public class DatosDeAlumno {

    private DatosPersonales personales;
    private Direccion direccion;

    public DatosDeAlumno(DatosPersonales personales, Direccion direccion) {
        this.personales = personales;
        this.direccion  = direccion;
    }

    public DatosPersonales getPersonales() { return personales; }
    public Direccion       getDireccion()  { return direccion; }

    public static String[] cabecera() {
        String[] dp = DatosPersonales.cabecera();
        String[] di = Direccion.cabecera();
        String[] total = new String[dp.length + di.length];
        for (int i = 0; i < dp.length; i++) total[i] = dp[i];
        for (int i = 0; i < di.length; i++) total[dp.length + i] = di[i];
        return total;
    }

    public String[] aFila() {
        String[] dp = personales.aFila();
        String[] di = direccion.aFila();
        String[] total = new String[dp.length + di.length];
        for (int i = 0; i < dp.length; i++) total[i] = dp[i];
        for (int i = 0; i < di.length; i++) total[dp.length + i] = di[i];
        return total;
    }
}