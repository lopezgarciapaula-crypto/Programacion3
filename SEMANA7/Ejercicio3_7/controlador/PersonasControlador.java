package controlador;

import modelo.Persona;
import modelo.PersonasModel;
import vista.PersonasVista;

public class PersonasControlador {
    private PersonasModel modelo;
    private PersonasVista vista;

    public PersonasControlador(PersonasModel modelo, PersonasVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregar() {
        String nombre = vista.leerString("Ingrese el nombre de la persona:");
        int edad = vista.leerEntero("Ingrese la edad de la persona:");
        double altura = vista.leerDouble("Ingrese la altura de la persona (ej. 1,75):");
        
        Persona p = new Persona(nombre, edad, altura);
        modelo.agregarPersona(p);
        vista.mostrarMensaje("Persona añadida correctamente."); 
    }

    public void eliminar() {
        String nombre = vista.leerString("Ingrese el nombre de la persona a eliminar:");
        if (modelo.eliminarPersona(nombre)) {
            vista.mostrarMensaje("Persona eliminada.");
        } else {
            vista.mostrarMensaje("Persona no encontrada.");
        }
    }

    public void modificar() {
        String nombreViejo = vista.leerString("Ingrese el nombre de la persona a modificar:");
        String nuevoNombre = vista.leerString("Ingrese el nuevo nombre:");
        int nuevaEdad = vista.leerEntero("Ingrese la nueva edad:");
        double nuevaAltura = vista.leerDouble("Ingrese la nueva altura (ej. 1,75):");

        if (modelo.modificarPersona(nombreViejo, nuevoNombre, nuevaEdad, nuevaAltura)) {
            vista.mostrarMensaje("Persona modificada correctamente.");
        } else {
            vista.mostrarMensaje("Persona no encontrada.");
        }
    }

    public void listar() {
        vista.mostrarLista(modelo.obtenerPersonas());
    }
}
