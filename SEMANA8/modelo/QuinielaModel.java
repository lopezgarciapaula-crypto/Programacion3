package SEMANA8.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuinielaModel {
    private Quiniela quiniela;

    public QuinielaModel() {
        this.quiniela = new Quiniela();
    }

    public void agregarPartido(String nombreLocal, String nombreVisitante) {
        Equipo local = new Equipo(nombreLocal);
        Equipo visitante = new Equipo(nombreVisitante);
        quiniela.agregarPartido(new Partido(local, visitante));
    }

    // V2: Carga desde fichero
    public void cargarPartidosDesdeFichero() {
        // Ruta relativa directa (más segura en VS Code)
        String ruta = "SEMANA8/datos/equipos.txt";
        File fichero = new File(ruta);

        try (Scanner sc = new Scanner(fichero)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine().trim();
                if (linea.isEmpty()) continue;

                // Separamos por el guion
                String[] partes = linea.split("-");
                if (partes.length == 2) {
                    quiniela.agregarPartido(
                        new Partido(new Equipo(partes[0].trim()), new Equipo(partes[1].trim()))
                    );
                }
            }
            System.out.println("¡Partidos cargados correctamente desde el fichero!");
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontro el fichero en la ruta: " + ruta);
            System.out.println("Asegurate de que el archivo existe en: SEMANA8/datos/equipos.txt");
        }
    }

    public boolean registrarResultado(int indice, String resultado) {
        if (indice < 0 || indice >= quiniela.getPartidos().size()) return false;
        quiniela.getPartidos().get(indice).setResultado(resultado);
        return true;
    }

    public Quiniela getQuiniela() { 
        return quiniela; 
    }
}