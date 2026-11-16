package vista;

import modelo.DatosDeAlumno;
import es.usal.progiii.tools.Esdia;
import es.usal.progiii.tools.OpMat;

import java.util.List;

public class Vista {

    public void mensaje(String texto) {
        System.out.println(texto);
    }

    public String mostrarMenu() {
        System.out.println("\n===== LISTA DE CLASE =====");
        System.out.println("1  Volver a crear la lista de alumnos");
        System.out.println("2  Mostrar tabla de alumnos");
        System.out.println("3  Exportar datos personales (CSV)");
        System.out.println("4  Exportar direcciones (CSV)");
        System.out.println("q  Salir");
        return Esdia.readString("Elige opcion: ");
    }

    public boolean confirmarSalida() {
        return Esdia.siOno("Seguro que quieres salir? (s/n): ");
    }

    public void mostrarTabla(List<DatosDeAlumno> alumnos) {
        if (alumnos.isEmpty()) {
            System.out.println("(Lista vacia)");
            return;
        }
        String[][] tabla = new String[alumnos.size() + 1][];
        tabla[0] = DatosDeAlumno.cabecera();
        for (int i = 0; i < alumnos.size(); i++) {
            tabla[i + 1] = alumnos.get(i).aFila();
        }
        OpMat.printToScreen(tabla);
    }
}