package vista;

import modelo.Persona;
import es.usal.progiii.tools.Esdia;
import es.usal.progiii.tools.OpMat;

import java.util.List;

public class Vista {

    public void mensaje(String texto) {
        System.out.println(texto);
    }

    public int mostrarMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Importar fichero TSV");
        System.out.println("2. Mostrar personas en tabla");
        System.out.println("3. Salir");
        return Esdia.readInt("Elige opcion: ");
    }

    public String pedirFichero() {
        return Esdia.readString("Nombre del fichero (en el escritorio): ");
    }

    public boolean confirmarSalida() {
        return Esdia.siOno("Seguro que quieres salir? (s/n): ");
    }

    public void mostrarTabla(List<Persona> personas) {
        if (personas.isEmpty()) {
            System.out.println("(No hay personas)");
            return;
        }
        String[][] tabla = new String[personas.size() + 1][];
        tabla[0] = Persona.cabecera();
        for (int i = 0; i < personas.size(); i++) {
            tabla[i + 1] = personas.get(i).aFila();
        }
        OpMat.printToScreen(tabla);
    }
}