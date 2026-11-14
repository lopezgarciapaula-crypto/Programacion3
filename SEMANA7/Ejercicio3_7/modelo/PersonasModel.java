package modelo;

import java.util.ArrayList;

public class PersonasModel {
    private ArrayList<Persona> personas;

    public PersonasModel() {
        this.personas = new ArrayList<>();
    }

    public void agregarPersona(Persona p) {
        personas.add(p);
    }

    public boolean eliminarPersona(String nombre) {
        for (Persona persona : personas) {
            if (persona.getNombre().equals(nombre)) {
                personas.remove(persona);
                return true; 
            }
        }
        return false; 
    }

    public boolean modificarPersona(String nombreViejo, String nuevoNombre, int nuevaEdad, double nuevaAltura) {
        for (Persona persona : personas) {
            if (persona.getNombre().equals(nombreViejo)) {
                persona.setNombre(nuevoNombre);
                persona.setEdad(nuevaEdad);
                persona.setAltura(nuevaAltura);
                return true; 
            }
        }
        return false; 
    }

    public ArrayList<Persona> obtenerPersonas() {
        return personas;
    }
}
