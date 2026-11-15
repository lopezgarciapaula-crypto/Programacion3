package SEMANA8.modelo;

import java.io.File;
import java.nio.file.Path;

// IMPORTAMOS LAS CLASES 
import es.usal.progiii.tools.Rutas;
import es.usal.progiii.tools.OpMat;

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

    // V2: Carga desde fichero usando la clase Rutas dadas
    public void cargarPartidosDesdeFichero() {
        // 1. Usamos Rutas para obtener la ruta del Escritorio del usuario de forma automática
        Path ruta = java.nio.file.Paths.get("SEMANA8/datos/equipos.txt");
        File fichero = ruta.toFile();

        try {
            // 2. Usamos OpMat para leer el fichero. 
            // Le decimos que el separador entre equipos es el guion "-"
            String[][] datos = OpMat.importFromDisk(fichero, "-");
            
            // 3. Recorremos los datos leídos y los guardamos en nuestra Quiniela
            for (String[] fila : datos) {
                if (fila.length == 2) {
                    quiniela.agregarPartido(
                        new Partido(new Equipo(fila[0].trim()), new Equipo(fila[1].trim()))
                    );
                }
            }
            System.out.println("¡Partidos cargados correctamente desde el fichero!");
        } catch (Exception e) {
            System.out.println("Aviso: No se pudo cargar el fichero de equipos.");
            System.out.println("Ruta buscada: " + ruta);
            System.out.println("Detalle del error: " + e.getMessage());
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